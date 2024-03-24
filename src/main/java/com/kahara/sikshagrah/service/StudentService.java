package com.kahara.sikshagrah.service;

import java.util.List;

import com.kahara.sikshagrah.dto.StudentDto;


public interface StudentService {
	StudentDto getStudendByRoll(Long roll);
	List<StudentDto> getAllStudent();
	StudentDto addStudent(StudentDto studentDto);
	StudentDto updateStudent(StudentDto studentDto);
	void deleteStudent(Long roll);
}
