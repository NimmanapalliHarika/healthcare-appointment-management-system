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
	private Double consultationFee;
	
	@NotNull(message = "Please select Gender")
	private Gender gender;
	
	@NotNull(message = "Please select Availability")
	private Boolean available;

	public DoctorRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorRequest(@NotBlank(message = "Please enter FirstName") String firstName,
			@NotBlank(message = "Please enter LastName") String lastName,
			@Email(message = "Please enter valid email") @NotBlank(message = "Please enter email") String email,
			@NotBlank(message = "Please enter PhoneNumber ") @Pattern(regexp = "^[6-9]\\d{9}$", message = "Please enter valid phoneNumber") String phoneNumber,
			@NotNull(message = "Please select Specialization") Specialization specialization,
			@NotBlank(message = "Please enter Qualification") String qualification,
			@NotNull(message = "Please enter Experience") Integer experience,
			@NotNull(message = "Please enter Consultation Fee") Double consultationFee,
			@NotNull(message = "Please select Gender") Gender gender,
			@NotNull(message = "Please select Availability") Boolean available) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.specialization = specialization;
		this.qualification = qualification;
		this.experience = experience;
		this.consultationFee = consultationFee;
		this.gender = gender;
		this.available = available;
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

	public Double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(Double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	

}
