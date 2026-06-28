package com.harika.patientservice.mapper;

import org.springframework.stereotype.Component;

import com.harika.patientservice.dto.request.PatientRequest;
import com.harika.patientservice.dto.response.PatientResponse;
import com.harika.patientservice.entity.Patient;

@Component
public class PatientMapper {
	
	public Patient toEntity(PatientRequest request) {

	    if (request == null) {
	        return null;
	    }

	    Patient patient = new Patient();

	    patient.setFirstName(request.getFirstName());
	    patient.setLastName(request.getLastName());
	    patient.setEmail(request.getEmail());
	    patient.setPhoneNumber(request.getPhoneNumber());
	    patient.setGender(request.getGender());
	    patient.setBloodGroup(request.getBloodGroup());
	    patient.setDateOfBirth(request.getDateOfBirth());
	    patient.setAddress(request.getAddress());

	    return patient;
	}
	
	public PatientResponse toResponse(Patient patient) {

	    if (patient == null) {
	        return null;
	    }

	    PatientResponse response = new PatientResponse();

	    response.setPatientId(patient.getPatientId());
	    response.setFirstName(patient.getFirstName());
	    response.setLastName(patient.getLastName());
	    response.setEmail(patient.getEmail());
	    response.setPhoneNumber(patient.getPhoneNumber());
	    response.setGender(patient.getGender());
	    response.setBloodGroup(patient.getBloodGroup());
	    response.setDateOfBirth(patient.getDateOfBirth());
	    response.setAddress(patient.getAddress());
	    response.setCreatedAt(patient.getCreatedAt());

	    return response;
	}
}
