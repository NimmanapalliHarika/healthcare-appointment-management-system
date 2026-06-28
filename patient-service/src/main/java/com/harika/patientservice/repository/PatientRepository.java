package com.harika.patientservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harika.patientservice.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

	boolean existsByEmail(String email);
	boolean existsByPhoneNumber(String phoneNumber);

    Optional<Patient> findByEmail(String email);

    Optional<Patient> findByPhoneNumber(String phoneNumber);
}
