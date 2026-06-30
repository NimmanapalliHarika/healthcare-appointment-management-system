package com.harika.doctorservice.service.impl;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.harika.doctorservice.dto.request.DoctorRequest;
import com.harika.doctorservice.dto.response.DoctorResponse;
import com.harika.doctorservice.entity.Doctor;
import com.harika.doctorservice.exception.DuplicateResourceException;
import com.harika.doctorservice.exception.ResourceNotFoundException;
import com.harika.doctorservice.mapper.DoctorMapper;
import com.harika.doctorservice.repository.DoctorRepository;
import com.harika.doctorservice.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorServiceImpl(DoctorRepository doctorRepository,
                             DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }
    @Override
    public DoctorResponse registerDoctor(DoctorRequest request) {

        if (doctorRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException(
                    "Doctor already exists with email: " + request.getEmail());
        }

        if (doctorRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new DuplicateResourceException(
                    "Doctor already exists with phone number: " + request.getPhoneNumber());
        }

        Doctor doctor = doctorMapper.toEntity(request);

        Doctor savedDoctor = doctorRepository.save(doctor);

        return doctorMapper.toResponse(savedDoctor);
    }
    @Cacheable(value = "doctors", key = "#doctorId")
    @Override
    public DoctorResponse getDoctorById(Long doctorId) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with id: " + doctorId));

        return doctorMapper.toResponse(doctor);
    }
    
    @Override
    public List<DoctorResponse> getAllDoctors() {

        return doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toResponse)
                .toList();
    }
    @CachePut(value = "doctors", key = "#doctorId")
    @Override
    public DoctorResponse updateDoctor(Long doctorId, DoctorRequest request) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with id: " + doctorId));

        if (request.getFirstName() != null)
            doctor.setFirstName(request.getFirstName());

        if (request.getLastName() != null)
            doctor.setLastName(request.getLastName());

        if (request.getEmail() != null)
            doctor.setEmail(request.getEmail());

        if (request.getPhoneNumber() != null)
            doctor.setPhoneNumber(request.getPhoneNumber());

        if (request.getSpecialization() != null)
            doctor.setSpecialization(request.getSpecialization());

        if (request.getQualification() != null)
            doctor.setQualification(request.getQualification());

        if (request.getExperience() != null)
            doctor.setExperience(request.getExperience());

        if (request.getConsultationFee() != null)
            doctor.setConsultationFee(request.getConsultationFee());

        if (request.getGender() != null)
            doctor.setGender(request.getGender());

        if (request.getAvailable() != null)
            doctor.setAvailable(request.getAvailable());

        Doctor updatedDoctor = doctorRepository.save(doctor);

        return doctorMapper.toResponse(updatedDoctor);
    }
    @CacheEvict(value = "doctors", key = "#doctorId")
    @Override
    public void deleteDoctor(Long doctorId) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with id: " + doctorId));

        doctorRepository.delete(doctor);
    }

}
