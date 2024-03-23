package com.kahara.sikshagrah.dto;

import java.time.LocalDate;
import java.util.Arrays;

import com.kahara.sikshagrah.enums.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StudentDto {

	private Long roll;

	@NotBlank(message = "First name is required")
	@Size(max = 50, message = "First name cannot exceed 50 characters")
	private String fname;

	@NotBlank(message = "Last name is required")
	@Size(max = 50, message = "Last name cannot exceed 50 characters")
	private String lname;

	@Email(message = "Please enter a valid email address")
	private String email;

	private Gender gender;
	
	@NotNull(message = "Date of birth is required")
	private LocalDate dob;

	public StudentDto() {
		super();
	}

	public StudentDto(Long roll, String fname, String lname, String email, Gender gender, LocalDate dob) {
		super();
		this.roll = roll;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
	}

	public Long getRoll() {
		return roll;
	}

	public void setRoll(Long roll) {
		this.roll = roll;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public boolean isValidGender(Gender gender) {
		return gender != null && Arrays.stream(Gender.values()).anyMatch(g -> g == gender);
	}

	public void setGender(Gender gender) {
		if (!isValidGender(gender)) {
			throw new IllegalArgumentException("Invalid gender value provided");
		}
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "StudentDto [roll=" + roll + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", gender="
				+ gender + ", dob=" + dob + "]";
	}

}
