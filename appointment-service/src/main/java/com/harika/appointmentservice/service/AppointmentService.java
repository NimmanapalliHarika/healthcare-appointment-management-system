package com.harika.appointmentservice.service;

import java.util.List;

import com.harika.appointmentservice.dto.request.AppointmentRequest;
import com.harika.appointmentservice.dto.response.AppointmentResponse;

public interface AppointmentService {

    AppointmentResponse bookAppointment(AppointmentRequest request);

    AppointmentResponse getAppointmentById(Long appointmentId);

    List<AppointmentResponse> getAllAppointments();

    AppointmentResponse updateAppointment(Long appointmentId,
                                          AppointmentRequest request);

    void cancelAppointment(Long appointmentId);

}