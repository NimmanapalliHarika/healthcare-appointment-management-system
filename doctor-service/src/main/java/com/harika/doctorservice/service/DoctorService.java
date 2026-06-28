package com.harika.doctorservice.service;

import java.util.List;

import com.harika.doctorservice.dto.request.DoctorRequest;
import com.harika.doctorservice.dto.response.DoctorResponse;

public interface DoctorService {
	DoctorResponse registerDoctor(DoctorRequest request);

    DoctorResponse getDoctorById(Long doctorId);

    List<DoctorResponse> getAllDoctors();

    DoctorResponse updateDoctor(Long doctorId, DoctorRequest request);

    void deleteDoctor(Long doctorId);
}
