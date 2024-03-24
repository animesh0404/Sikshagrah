package com.kahara.sikshagrah.helper;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.kahara.sikshagrah.dto.StudentDto;
import com.kahara.sikshagrah.model.Student;

public abstract class StudentHelper {

	private StudentHelper() {
		throw new IllegalStateException("Cannot instantiate as it's a Helper class");
	}

	public static StudentDto entityToDto(Student student) {
		StudentDto studentDto = new StudentDto();
		BeanUtils.copyProperties(student, studentDto);
		return studentDto;
	}

	public static List<StudentDto> entityToDto(List<Student> students) {
		return students.stream().map(s -> entityToDto(s)).toList();
	}

	public static Student dtoToEntity(StudentDto studentDto) {
		Student student = new Student();
		BeanUtils.copyProperties(studentDto, student);
		return student;
	}

	public static List<Student> dtoToEntity(List<StudentDto> studentDtos) {
		return studentDtos.stream().map(s -> dtoToEntity(s)).toList();
	}
}
