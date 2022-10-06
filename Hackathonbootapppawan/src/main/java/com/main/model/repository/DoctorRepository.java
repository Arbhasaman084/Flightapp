package com.main.model.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	@Query("select d from Doctor d where d.appointmentDate=?1 and d.session=?2 and d.slot=?3")
	List<Doctor> getFilteredDoctor(LocalDate appdate, String session, String slot);

	@Query("select d from Doctor d group by(speciality) having d.appointmentDate=?1 and d.session=?2 and d.slot=?3")
	List<Doctor> getFilteredSpeciality(LocalDate appdate, String session, String slot);
	

}
