package com.harika.appointmentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.harika.appointmentservice.dto.external.DoctorResponse;

@FeignClient(name = "DOCTOR-SERVICE")
public interface DoctorClient {

    @GetMapping("/api/v1/doctors/{doctorId}")
    DoctorResponse getDoctorById(@PathVariable("doctorId") Long doctorId);

}