package com.kahara.sikshagrah.helper;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.kahara.sikshagrah.dto.StudentDto;
import com.kahara.sikshagrah.model.Student;

public abstract class StudentHelper {

	StudentDto entityToDto(Student student) {
		StudentDto studentDto = new StudentDto();
		BeanUtils.copyProperties(student, studentDto);
		return studentDto;
	}

	List<StudentDto> entityToDto(List<Student> students) {
		return students.stream().map(this::entityToDto).toList();
	}

	Student dtoToEntity(StudentDto studentDto) {
		Student student = new Student();
		BeanUtils.copyProperties(studentDto, student);
		return student;
	}

	List<Student> dtoToEntity(List<StudentDto> studentDtos) {
		return studentDtos.stream().map(this::dtoToEntity).toList();
	}
}
