package com.sample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.repository.MemberRepository;

import com.sample.demo.entity.Members;
import com.sample.demo.exception.ResourceNotFoundException;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MemberController {
	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping("/ping")
	public String healthCheck() {
		return "All Ok.";
	}
	
	@GetMapping("/members/{id}")
	public ResponseEntity<Members> getMemberById(@PathVariable(value="id") int id) throws ResourceNotFoundException{
		Members m = memberRepository.findByMemberId(id);

		if (m == null) {
				new ResourceNotFoundException("Member not found. Please register to continue");
		}
		return ResponseEntity.ok().body(m);
	}
}
