package com.harika.patientservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.harika.patientservice.enums.BloodGroup;
import com.harika.patientservice.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "patients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;
	
	@Column(nullable = false, length = 100)
	private String firstName;
	
	@Column(nullable = false, length = 100)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true, length = 10)
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private BloodGroup bloodGroup;
	
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	
	@Column(nullable = false, length = 255)
	private String address;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(Long patientId, String firstName, String lastName, String email, String phoneNumber, Gender gender,
			BloodGroup bloodGroup, LocalDate dateOfBirth, String address, LocalDateTime createdAt) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.createdAt = createdAt;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	

	

}
