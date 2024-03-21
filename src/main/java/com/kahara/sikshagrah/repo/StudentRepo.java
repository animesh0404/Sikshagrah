package com.kahara.sikshagrah.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kahara.sikshagrah.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{
	
}
