package com.appointment_ms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment_ms.PatientRepository;
import com.appointment_ms.PatientUser;
import com.appointment_ms.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;
	
	// get all employees
	@GetMapping("/users")
	public List<PatientUser> getAllUsers(){
		return patientRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/users")
	public PatientUser createUser(@RequestBody PatientUser user) {
		return patientRepository.save(user);
	}
	
	// get employee by id rest api
	@GetMapping("/users/{id}")
	public ResponseEntity<PatientUser> getUserByAccno(@PathVariable Long id) {
		PatientUser user = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient ID entered is Wrong :" + id));
		return ResponseEntity.ok(user);
	}
	
	// update employee rest api
	
	@PutMapping("/users/{id}")
	public ResponseEntity<PatientUser> updateUser(@PathVariable Long id, @RequestBody PatientUser userDetails){
		PatientUser user = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient ID entered is Wrong :" + id));
		
		user.setFirstName(userDetails.getFirstName());
		user.setEmailId(userDetails.getEmailId());
		user.setFrom(userDetails.getFrom());
		user.setTiming(userDetails.getTiming());
		user.setConsul(userDetails.getConsul());
		user.setSpec(userDetails.getSpec());
		user.setStatusap(userDetails.getStatusap());
		
		PatientUser updatedUser = patientRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	// delete employee rest api
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		PatientUser user = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient ID entered is Wrong :" + id));
		
		patientRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
