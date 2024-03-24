package com.kahara.sikshagrah.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kahara.sikshagrah.dto.StudentDto;
import com.kahara.sikshagrah.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/students")
	List<StudentDto> getAllStudent() {
		return studentService.getAllStudent();
	}

	@GetMapping("/student/{roll}")
	StudentDto getStudentById(@PathVariable("roll") Long roll) {
		return studentService.getStudendByRoll(roll);
	}

	@PostMapping("/student")
	StudentDto addStudent(@RequestBody StudentDto newStudent) {
		return studentService.addStudent(newStudent);
	}

	@PutMapping("/student")
	StudentDto updateStudent(@RequestBody StudentDto updatedStudent) {
		return studentService.updateStudent(updatedStudent);
	}

	@DeleteMapping("/student/{roll}")
	String deleteStudent(@PathVariable("roll") Long roll) {
		studentService.deleteStudent(roll);
		return "Student with roll no " + roll + " deleted.";
	}
}
