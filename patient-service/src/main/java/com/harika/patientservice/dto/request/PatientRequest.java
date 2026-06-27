package com.harika.patientservice.dto.request;

import java.time.LocalDate;

import com.harika.patientservice.enums.BloodGroup;
import com.harika.patientservice.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public class PatientRequest {
	
	
	@NotBlank(message = "First name is required")
	private String firstName;
	
	
	@NotBlank(message = "Last name is required")
	private String lastName;
	
	
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;
	
	@NotBlank(message = "Phone number is required")
	@Pattern(
	    regexp = "^[6-9]\\d{9}$",
	    message = "Phone number must be a valid 10-digit Indian mobile number"
	)
	private String phoneNumber;
	
	
	

	@Past(message = "Date of birth must be in the past")
	private LocalDate dateOfBirth;
	
	
	@NotBlank(message = "Address is required")
	private String address;

}
