package com.main.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Doctor;
import com.main.model.repository.DoctorRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:9416"})
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
	
	@GetMapping("/doctor/get/{session}/{slot}/{date}")
	public List<Doctor> getFilteredDoctors(@PathVariable("date") String date,
									@PathVariable("session") String session,
									@PathVariable("slot") String slot) {

		LocalDate appdate =  LocalDate.parse(date);
		List<Doctor> list = doctorRepository.getFilteredDoctor(appdate,session,slot);
		return list;
	}
	
	@GetMapping("/speciality/get/{session}/{slot}/{date}")
	public List<Doctor> getspeciality(@PathVariable("date") String date,
			@PathVariable("session") String session,
			@PathVariable("slot") String slot){
		LocalDate appdate =  LocalDate.parse(date);
		List<Doctor> list = doctorRepository.getFilteredSpeciality(appdate,session,slot);
		System.out.println(list);
		return list;
	}

}
