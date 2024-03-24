package com.kahara.sikshagrah.serviceimpl;

import static com.kahara.sikshagrah.helper.StudentHelper.dtoToEntity;
import static com.kahara.sikshagrah.helper.StudentHelper.entityToDto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.kahara.sikshagrah.dto.StudentDto;
import com.kahara.sikshagrah.model.Student;
import com.kahara.sikshagrah.repo.StudentRepo;
import com.kahara.sikshagrah.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final StudentRepo studentRepo;
	
	public StudentServiceImpl(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public StudentDto getStudendByRoll(Long roll) {
		StudentDto dto = null;
		Optional<Student> entity = studentRepo.findById(roll);
		if (entity.isPresent()) {
			dto = entityToDto(entity.get());
		}
		return dto;
	}

	@Override
	public List<StudentDto> getAllStudent() {
		return entityToDto(studentRepo.findAll());
	}

	@Override
	public StudentDto addStudent(StudentDto newStudent) {
		return entityToDto(studentRepo.save(dtoToEntity(newStudent)));
	}

	@Override
	public StudentDto updateStudent(StudentDto dto) {
		return studentRepo.findById(dto.getRoll()).map(student -> {
			BeanUtils.copyProperties(dtoToEntity(dto), student);
			return entityToDto(studentRepo.save(student));
		}).orElse(null);
	}

	@Override
	public void deleteStudent(Long roll) {
		studentRepo.deleteById(roll);
	}

}
