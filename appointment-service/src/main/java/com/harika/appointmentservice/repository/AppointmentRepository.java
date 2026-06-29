package com.harika.appointmentservice.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harika.appointmentservice.entity.Appointment;
import com.harika.appointmentservice.enums.AppointmentStatus;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	 List<Appointment> findByPatientId(Long patientId);

	    List<Appointment> findByDoctorId(Long doctorId);

	    List<Appointment> findByStatus(AppointmentStatus status);

	    List<Appointment> findByAppointmentDate(LocalDate appointmentDate);
}
