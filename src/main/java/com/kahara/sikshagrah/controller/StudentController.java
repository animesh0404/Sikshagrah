package com.kahara.sikshagrah.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	private StudentRepo studentRepo;

	@GetMapping("/students")
	List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	@GetMapping("/student/{roll}")
	Student getStudentById(@PathVariable("roll") Long roll) {
		return studentRepo.findById(roll).get();
	}

	@PostMapping("/student")
	Student addStudent(@RequestBody Student newStudent) {
		return studentRepo.save(newStudent);
	}

	@PutMapping("/student")
	Student updateStudent(@RequestBody Student updatedStudent) {
		Long roll = updatedStudent.getRoll();
		Optional<Student> existingStudent = studentRepo.findById(roll);
		Student temp = null;
		if (existingStudent.isPresent()) {
			temp = existingStudent.get();
			BeanUtils.copyProperties(updatedStudent, temp);
			temp = studentRepo.save(temp);
		}
		return temp;
	}

	@DeleteMapping("/student/{roll}")
	String deleteStudent(@PathVariable("roll") Long roll) {
		studentRepo.deleteById(roll);
		return "Student with roll no " + roll + " deleted.";
	}
}
