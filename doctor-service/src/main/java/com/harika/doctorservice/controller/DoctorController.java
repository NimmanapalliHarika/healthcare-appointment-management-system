package com.harika.doctorservice.controller;

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

import com.harika.doctorservice.dto.request.DoctorRequest;
import com.harika.doctorservice.dto.response.DoctorResponse;
import com.harika.doctorservice.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorResponse> registerDoctor(
            @Valid @RequestBody DoctorRequest request) {

        DoctorResponse response = doctorService.registerDoctor(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorResponse> getDoctorById(
            @PathVariable("doctorId") Long doctorId) {

        return ResponseEntity.ok(doctorService.getDoctorById(doctorId));
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponse>> getAllDoctors() {

        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<DoctorResponse> updateDoctor(
            @PathVariable("doctorId") Long doctorId,
            @Valid @RequestBody DoctorRequest request) {

        return ResponseEntity.ok(
                doctorService.updateDoctor(doctorId, request));
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<String> deleteDoctor(
            @PathVariable("doctorId") Long doctorId) {

        doctorService.deleteDoctor(doctorId);

        return ResponseEntity.ok("Doctor deleted successfully.");
    }
}