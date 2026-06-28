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
