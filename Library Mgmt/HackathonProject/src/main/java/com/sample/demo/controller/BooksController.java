package com.sample.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.entity.Books;
import com.sample.demo.exception.ResourceNotFoundException;
import com.sample.demo.repository.BooksRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BooksController {
	@Autowired
	BooksRepository bookRepository;
	
	@GetMapping("/books")
	public List<Books> listAllBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Books> getBookDetails(@PathVariable("id") int id) throws ResourceNotFoundException {
		Books b = bookRepository.findByBookId(id);
		
		if (b == null) {
			throw new ResourceNotFoundException("Book with id " + id + " not found");
		}
		
		return ResponseEntity.ok().body(b);
	}
	
	@GetMapping("/books/top")
	public ResponseEntity<Books> getLastRow() {
		Books b = bookRepository.findTopByOrderByBookIdDesc();
		return ResponseEntity.ok().body(b);
	}
	
	@GetMapping("/books/avail/{avail}")
	public List<Books> listBooksOnAvailability(@PathVariable("avail") boolean avail) {
		return bookRepository.findByAvailability(avail);
	}
	
	@PostMapping("/books")
	public Books addBook(@RequestBody Books book) {
		Books b = bookRepository.findTopByOrderByBookIdDesc();
		
		int id = b.getBookId() + 1;
		book.setBookId(id);
		return bookRepository.save(book);
	}
	
	@PutMapping("/books/update/{id}/{avail}")
	@Transactional
	public ResponseEntity<String> updateBookAvailability(@PathVariable("id") int id, @PathVariable("avail") boolean avail) 
			throws ResourceNotFoundException {
		Books b = bookRepository.findByBookId(id);
		
		if (b == null) {
			throw new ResourceNotFoundException("Book with id " + id + " not found");
		}
		
		bookRepository.updateBookAvailability(id, avail);
		return ResponseEntity.ok().body("Book Availabilty updated for book id: " + id);
	}
}
