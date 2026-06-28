package com.harika.doctorservice.dto.response;

import java.time.LocalDateTime;

import com.harika.doctorservice.enums.Gender;
import com.harika.doctorservice.enums.Specialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {
	private Long doctorId;
	public DoctorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorResponse(Long doctorId, String firstName, String lastName, String email, String phoneNumber,
			Specialization specialization, String qualification, Integer experience, Gender gender,
			Double consultationFee, Boolean available, LocalDateTime createdAt) {
		super();
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.specialization = specialization;
		this.qualification = qualification;
		this.experience = experience;
		this.gender = gender;
		this.consultationFee = consultationFee;
		this.available = available;
		this.createdAt = createdAt;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Double getConsultationFee() {
		return consultationFee;
	}
	public void setConsultationFee(Double consultationFee) {
		this.consultationFee = consultationFee;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Specialization specialization;
	private String qualification;
	private Integer experience;
	private Gender gender;
	private Double consultationFee;
	private Boolean available;
	private LocalDateTime createdAt;
}
