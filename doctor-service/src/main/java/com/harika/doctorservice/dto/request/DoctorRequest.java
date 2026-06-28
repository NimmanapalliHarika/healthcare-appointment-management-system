package com.harika.doctorservice.dto.request;

import com.harika.doctorservice.enums.Gender;
import com.harika.doctorservice.enums.Specialization;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequest {
	
	@NotBlank(message = "Please enter FirstName")
	private String firstName;
	
	@NotBlank(message = "Please enter LastName")
	private String lastName;
	
	
	@Email(message = "Please enter valid email")
	@NotBlank(message = "Please enter email")
	private String email;
	
	@NotBlank(message = "Please enter PhoneNumber ")
	@Pattern(regexp = "^[6-9]\\d{9}$",message = "Please enter valid phoneNumber")
	private String phoneNumber;
	
	@NotNull(message = "Please select Specialization")
	private Specialization specialization;
	
	@NotBlank(message = "Please enter Qualification")
	private String qualification;
	
	@NotNull(message = "Please enter Experience")
	private Integer experience;

	@NotNull(message = "Please enter Consultation Fee")
	private double consultationFee;
	
	@NotNull(message = "Please select Gender")
	private Gender gender;
	
	@NotNull(message = "Please select Availability")
	private Boolean available;
	

}
