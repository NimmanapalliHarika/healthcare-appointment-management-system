package com.harika.appointmentservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.harika.appointmentservice.client.DoctorClient;
import com.harika.appointmentservice.client.PatientClient;
import com.harika.appointmentservice.dto.external.DoctorResponse;
import com.harika.appointmentservice.dto.external.PatientResponse;
import com.harika.appointmentservice.dto.request.AppointmentRequest;
import com.harika.appointmentservice.dto.response.AppointmentResponse;
import com.harika.appointmentservice.entity.Appointment;
import com.harika.appointmentservice.exception.BadRequestException;
import com.harika.appointmentservice.exception.ResourceNotFoundException;
import com.harika.appointmentservice.mapper.AppointmentMapper;
import com.harika.appointmentservice.repository.AppointmentRepository;
import com.harika.appointmentservice.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final PatientClient patientClient;
    private final DoctorClient doctorClient;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  AppointmentMapper appointmentMapper,
                                  PatientClient patientClient,
                                  DoctorClient doctorClient) {

        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
        this.patientClient = patientClient;
        this.doctorClient = doctorClient;
    }
    @Override
    public AppointmentResponse bookAppointment(AppointmentRequest request) {

        // Validate Patient
        PatientResponse patient =
                patientClient.getPatientById(request.getPatientId());

        // Validate Doctor
        DoctorResponse doctor =
                doctorClient.getDoctorById(request.getDoctorId());

        // Check Doctor Availability
        if (!doctor.getAvailable()) {
            throw new BadRequestException(
                    "Doctor is currently unavailable.");
        }

        Appointment appointment = appointmentMapper.toEntity(request);

        Appointment savedAppointment =
                appointmentRepository.save(appointment);

        return appointmentMapper.toResponse(savedAppointment);
    }
    @Override
    public AppointmentResponse getAppointmentById(Long appointmentId) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + appointmentId));

        return appointmentMapper.toResponse(appointment);
    }
    @Override
    public List<AppointmentResponse> getAllAppointments() {

        return appointmentRepository.findAll()
                .stream()
                .map(appointmentMapper::toResponse)
                .toList();
    }
    @Override
    public AppointmentResponse updateAppointment(Long appointmentId,
                                                 AppointmentRequest request) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + appointmentId));

        if (request.getPatientId() != null) {
            patientClient.getPatientById(request.getPatientId());
            appointment.setPatientId(request.getPatientId());
        }

        if (request.getDoctorId() != null) {
            DoctorResponse doctor =
                    doctorClient.getDoctorById(request.getDoctorId());

            if (!doctor.getAvailable()) {
                throw new BadRequestException(
                        "Doctor is currently unavailable.");
            }

            appointment.setDoctorId(request.getDoctorId());
        }

        if (request.getAppointmentDate() != null)
            appointment.setAppointmentDate(request.getAppointmentDate());

        if (request.getAppointmentTime() != null)
            appointment.setAppointmentTime(request.getAppointmentTime());

        if (request.getReason() != null)
            appointment.setReason(request.getReason());

        if (request.getStatus() != null)
            appointment.setStatus(request.getStatus());

        Appointment updatedAppointment =
                appointmentRepository.save(appointment);

        return appointmentMapper.toResponse(updatedAppointment);
    }
    @Override
    public void cancelAppointment(Long appointmentId) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + appointmentId));

        appointmentRepository.delete(appointment);
    }

}