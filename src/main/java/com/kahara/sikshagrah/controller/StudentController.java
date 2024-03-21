package com.kahara.sikshagrah.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kahara.sikshagrah.model.Student;
import com.kahara.sikshagrah.repo.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	private StudentRepo studentRepo;

	@GetMapping("/students")
	List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	@GetMapping("/student/{ID}")
	Student getStudentById(@PathVariable("ID") Long id) {
		return studentRepo.findById(id).get();
	}

	@PostMapping("/student")
	Student addStudent(@RequestBody Student newStudent) {
		return studentRepo.save(newStudent);
	}

	@PutMapping("/student")
	Student updateStudent(@RequestBody Student updatedStudent) {
		Long id = updatedStudent.getId();
		Optional<Student> existingStudent = studentRepo.findById(id);
		Student temp = null;
		if (existingStudent.isPresent()) {
			temp = existingStudent.get();
			BeanUtils.copyProperties(updatedStudent, temp);
			temp = studentRepo.save(temp);
		}
		return temp;
	}

	@DeleteMapping("/student/{ID}")
	String deleteStudent(@PathVariable("ID") Long id) {
		studentRepo.deleteById(id);
		return "Student with id " + id + " deleted.";
	}
}
