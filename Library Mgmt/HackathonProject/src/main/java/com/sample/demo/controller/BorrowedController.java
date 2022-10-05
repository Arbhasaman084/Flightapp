package com.sample.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.entity.Borrowed;
import com.sample.demo.entity.Members;
import com.sample.demo.exception.ResourceNotFoundException;
import com.sample.demo.repository.BorrowedRepository;
import com.sample.demo.repository.MemberRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BorrowedController {
	@Autowired
	BorrowedRepository borrowedRepository;
	
//	@Autowired
//	MemberRepository memberRepository;
	
	@GetMapping("/borrow/due/{due}")
	public List<Borrowed> getAllDueBooks(@PathVariable("due") String due) {
		LocalDate ld = LocalDate.parse(due);
		
		return borrowedRepository.findAllBorrowedByDueDate(ld);
	}
	
	@GetMapping("/borrow/member/{id}")
	public List<Borrowed> getAllBooksByMember(@PathVariable("id") int id){
		return borrowedRepository.findAllBorrowedByMemberId(id);
	}
	
	@PostMapping("/borrow/save")
	public ResponseEntity<String> saveBorrowedBookData(@RequestBody Borrowed borrowed) {
		LocalDate ld = borrowed.getIssueDate();
		LocalDate newDate = ld.plusDays(7);
		borrowed.setDueDate(newDate);
		
		borrowedRepository.save(borrowed);
		return ResponseEntity.ok().body("Data uploaded");
	}
	
	@DeleteMapping("/borrow/delete/{id}")
	public ResponseEntity<String> deleteEntry(@PathVariable int id) throws ResourceNotFoundException {
		Borrowed b = borrowedRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Unable to find entry"));
		borrowedRepository.deleteById(id);
		return ResponseEntity.ok().body("Entry Removed");
	}
	
	@GetMapping("/borrow/{id}")
	public ResponseEntity<Borrowed> getBorrowedDetails(@PathVariable int id) throws ResourceNotFoundException {
		Borrowed b = borrowedRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Unable to find entry"));
		return ResponseEntity.ok().body(b);
	}
}
