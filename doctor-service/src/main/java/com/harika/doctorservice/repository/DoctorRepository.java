package com.harika.doctorservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harika.doctorservice.entity.Doctor;
import com.harika.doctorservice.enums.Specialization;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
	 boolean existsByEmail(String email);

	    boolean existsByPhoneNumber(String phoneNumber);

	    Optional<Doctor> findByEmail(String email);

	    Optional<Doctor> findByPhoneNumber(String phoneNumber);

	    List<Doctor> findBySpecialization(Specialization specialization);

	    List<Doctor> findByAvailableTrue();

}
