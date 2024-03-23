package com.kahara.sikshagrah.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kahara.sikshagrah.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_roll_seq")
	private Long roll;
	private String fname;
	private String lname;
	private String email;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	public Student() {
		super();
	}

	public Student(String fname, String lname, String email, Long roll, Gender gender, LocalDate dob) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.roll = roll;
		this.gender = gender;
		this.dob = dob;
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

	public Long getRoll() {
		return roll;
	}

	public void setRoll(Long roll) {
		this.roll = roll;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
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
		return "Student [roll=" + roll + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", gender="
				+ gender + ", dob=" + dob + "]";
	}

}
