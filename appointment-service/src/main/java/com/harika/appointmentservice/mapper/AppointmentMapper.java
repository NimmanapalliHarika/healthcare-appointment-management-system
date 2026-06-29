package com.harika.appointmentservice.mapper;

import org.springframework.stereotype.Component;

import com.harika.appointmentservice.dto.request.AppointmentRequest;
import com.harika.appointmentservice.dto.response.AppointmentResponse;
import com.harika.appointmentservice.entity.Appointment;

@Component
public class AppointmentMapper {

    public Appointment toEntity(AppointmentRequest request) {

        if (request == null) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setPatientId(request.getPatientId());
        appointment.setDoctorId(request.getDoctorId());
        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setAppointmentTime(request.getAppointmentTime());
        appointment.setReason(request.getReason());
        appointment.setStatus(request.getStatus());

        return appointment;
    }

    public AppointmentResponse toResponse(Appointment appointment) {

        if (appointment == null) {
            return null;
        }

        AppointmentResponse response = new AppointmentResponse();

        response.setAppointmentId(appointment.getAppointmentId());
        response.setPatientId(appointment.getPatientId());
        response.setDoctorId(appointment.getDoctorId());
        response.setAppointmentDate(appointment.getAppointmentDate());
        response.setAppointmentTime(appointment.getAppointmentTime());
        response.setReason(appointment.getReason());
        response.setStatus(appointment.getStatus());
        response.setCreatedAt(appointment.getCreatedAt());

        return response;
    }
}