package com.main.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
