package com.harika.patientservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harika.patientservice.dto.request.PatientRequest;
import com.harika.patientservice.dto.response.PatientResponse;
import com.harika.patientservice.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
	
	private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @PostMapping
    public ResponseEntity<PatientResponse> registerPatient(
            @Valid @RequestBody PatientRequest request) {

        PatientResponse response = patientService.registerPatient(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
        
        
    }
    
    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResponse> getPatientById(
    		  @PathVariable("patientId") Long patientId) {

        PatientResponse response = patientService.getPatientById(patientId);

        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {

        List<PatientResponse> response = patientService.getAllPatients();

        return ResponseEntity.ok(response);
    }
    @PutMapping("/{patientId}")
    public ResponseEntity<PatientResponse> updatePatient(
    		@PathVariable("patientId") Long patientId,
            @Valid @RequestBody PatientRequest request) {

        PatientResponse response =
                patientService.updatePatient(patientId, request);

        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{patientId}")
    public ResponseEntity<String> deletePatient(
    		@PathVariable("patientId") Long patientId) {

        patientService.deletePatient(patientId);

        return ResponseEntity.ok("Patient deleted successfully.");
    }

}
