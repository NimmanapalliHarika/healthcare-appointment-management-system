package com.harika.doctorservice.mapper;

import org.springframework.stereotype.Component;

import com.harika.doctorservice.dto.request.DoctorRequest;
import com.harika.doctorservice.dto.response.DoctorResponse;
import com.harika.doctorservice.entity.Doctor;

@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorRequest request) {

        if (request == null) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setFirstName(request.getFirstName());
        doctor.setLastName(request.getLastName());
        doctor.setEmail(request.getEmail());
        doctor.setPhoneNumber(request.getPhoneNumber());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setQualification(request.getQualification());
        doctor.setExperience(request.getExperience());
        doctor.setConsultationFee(request.getConsultationFee());
        doctor.setGender(request.getGender());
        doctor.setAvailable(request.getAvailable());

        return doctor;
    }

    public DoctorResponse toResponse(Doctor doctor) {

        if (doctor == null) {
            return null;
        }

        DoctorResponse response = new DoctorResponse();

        response.setDoctorId(doctor.getDoctorId());
        response.setFirstName(doctor.getFirstName());
        response.setLastName(doctor.getLastName());
        response.setEmail(doctor.getEmail());
        response.setPhoneNumber(doctor.getPhoneNumber());
        response.setSpecialization(doctor.getSpecialization());
        response.setQualification(doctor.getQualification());
        response.setExperience(doctor.getExperience());
        response.setConsultationFee(doctor.getConsultationFee());
        response.setGender(doctor.getGender());
        response.setAvailable(doctor.getAvailable());
        response.setCreatedAt(doctor.getCreatedAt());

        return response;
    }
}