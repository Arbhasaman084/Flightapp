package com.appointment_ms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointment_ms.PatientUser;

@Repository
public interface PatientRepository extends JpaRepository<PatientUser, Long>
{

}
