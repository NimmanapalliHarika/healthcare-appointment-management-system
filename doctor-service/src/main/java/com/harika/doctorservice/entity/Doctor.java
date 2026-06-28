package com.harika.doctorservice.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.harika.doctorservice.enums.Gender;
import com.harika.doctorservice.enums.Specialization;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctorId;
	
	@Column(nullable = false, length = 100)
	private String firstName;
	
	@Column(nullable = false, length = 100)
	private String lastName;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	@Column(nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Specialization specialization;
	
	@Column(nullable = false, length = 100)
	private String qualification;
	
	@Column(nullable = false)
	private Integer experience;
	
	@Column(nullable = false)
	private double consultationFee;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(nullable = false)
	private Boolean available;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	

}
