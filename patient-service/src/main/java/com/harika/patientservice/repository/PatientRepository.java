package com.harika.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harika.patientservice.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
