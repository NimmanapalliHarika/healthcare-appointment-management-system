package com.harika.appointmentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.harika.appointmentservice.dto.external.PatientResponse;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientClient {

    @GetMapping("/api/v1/patients/{patientId}")
    PatientResponse getPatientById(@PathVariable("patientId") Long patientId);

}