package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Doctor;
import com.main.model.repository.DoctorRepository;

@RestController
public class MainController {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@PostMapping("/doctor/post")
	public Doctor postDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	@GetMapping("/doctor/get/all")
	public List<Doctor> getDoctor() {
		List<Doctor> list = doctorRepository.findAll();
		return list;
	}
	
}
