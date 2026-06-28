package com.harika.patientservice.service;

import java.util.List;

import com.harika.patientservice.dto.request.PatientRequest;
import com.harika.patientservice.dto.response.PatientResponse;

public interface PatientService {
	
	PatientResponse registerPatient(PatientRequest request);

    PatientResponse getPatientById(Long patientId);

    List<PatientResponse> getAllPatients();

    PatientResponse updatePatient(Long patientId, PatientRequest request);

    void deletePatient(Long patientId);
}
 