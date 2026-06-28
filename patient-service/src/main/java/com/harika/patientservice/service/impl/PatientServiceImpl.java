package com.harika.patientservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.harika.patientservice.dto.request.PatientRequest;
import com.harika.patientservice.dto.response.PatientResponse;
import com.harika.patientservice.entity.Patient;
import com.harika.patientservice.exception.DuplicateResourceException;
import com.harika.patientservice.exception.ResourceNotFoundException;
import com.harika.patientservice.mapper.PatientMapper;
import com.harika.patientservice.repository.PatientRepository;
import com.harika.patientservice.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	   private final PatientRepository patientRepository;
	    private final PatientMapper patientMapper;

	    public PatientServiceImpl(PatientRepository patientRepository,
	                              PatientMapper patientMapper) {
	        this.patientRepository = patientRepository;
	        this.patientMapper = patientMapper;
	    }

	@Override
	public PatientResponse registerPatient(PatientRequest request) {
		if (patientRepository.existsByEmail(request.getEmail())) {
	        throw new DuplicateResourceException(
	                "Patient already exists with email: " + request.getEmail());
	    }

	    Patient patient = patientMapper.toEntity(request);

	    Patient savedPatient = patientRepository.save(patient);

	    return patientMapper.toResponse(savedPatient);
	}

	@Override
	public PatientResponse getPatientById(Long patientId) {
		 Patient patient = patientRepository.findById(patientId)
		            .orElseThrow(() ->
		                    new ResourceNotFoundException(
		                            "Patient not found with ID: " + patientId));

		    return patientMapper.toResponse(patient);
	}

	@Override
	public List<PatientResponse> getAllPatients() {
		return patientRepository.findAll()
	            .stream()
	            .map(patientMapper::toResponse)
	            .toList();
	}

	@Override
	public PatientResponse updatePatient(Long patientId, PatientRequest request) {
		Patient patient = patientRepository.findById(patientId)
	            .orElseThrow(() -> new ResourceNotFoundException(
	                    "Patient not found with ID: " + patientId));

	    // Update only the fields provided in the request

	    if (request.getFirstName() != null) {
	        patient.setFirstName(request.getFirstName());
	    }

	    if (request.getLastName() != null) {
	        patient.setLastName(request.getLastName());
	    }

	    if (request.getEmail() != null) {

	        if (!request.getEmail().equals(patient.getEmail())
	                && patientRepository.existsByEmail(request.getEmail())) {

	            throw new DuplicateResourceException(
	                    "Patient already exists with email: " + request.getEmail());
	        }

	        patient.setEmail(request.getEmail());
	    }

	    if (request.getPhoneNumber() != null) {

	        if (!request.getPhoneNumber().equals(patient.getPhoneNumber())
	                && patientRepository.existsByPhoneNumber(request.getPhoneNumber())) {

	            throw new DuplicateResourceException(
	                    "Phone number already exists.");
	        }

	        patient.setPhoneNumber(request.getPhoneNumber());
	    }

	    if (request.getGender() != null) {
	        patient.setGender(request.getGender());
	    }

	    if (request.getBloodGroup() != null) {
	        patient.setBloodGroup(request.getBloodGroup());
	    }

	    if (request.getDateOfBirth() != null) {
	        patient.setDateOfBirth(request.getDateOfBirth());
	    }

	    if (request.getAddress() != null) {
	        patient.setAddress(request.getAddress());
	    }

	    Patient updatedPatient = patientRepository.save(patient);

	    return patientMapper.toResponse(updatedPatient);
	}

	@Override
	public void deletePatient(Long patientId) {
		if (!patientRepository.existsById(patientId)) {
	        throw new ResourceNotFoundException(
	                "Patient not found with ID: " + patientId);
	    }

	    patientRepository.deleteById(patientId);
	}

}
