package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.ResourceNotFoundException;
import com.spring.model.Student;
import com.spring.repository.StudentRepository;

@RequestMapping("/api")
@RestController
public class StudentController {

		@Autowired
		StudentRepository repo;
		
		
		@GetMapping("/student")
		public List<Student> getStudents(){
			return repo.findAll();
		}
		
		@GetMapping("/student/{id}")
		public Student getStudent(@PathVariable String id) throws ResourceNotFoundException {
			
			Optional<Student> found = repo.findById(id);
			
			if (found.isPresent()) {
				return found.get();
			}
			throw new ResourceNotFoundException("Student", id);
		}
		
		@PostMapping("/student")
		public ResponseEntity<Student> createStudent(@RequestBody Student student){
			
			// insertOne, insertMany
			Student created = repo.insert(student);
			
			return ResponseEntity.status(201).body(created);
		}
		
		
		@PutMapping("/student")
		public Student updaStudent(@RequestBody Student student) {
			
			if (repo.existsById(student.getId())) {
				
				return repo.save(student);
				
			}
			throw new ResourceNotFoundException("Student", student.)
		}
}	
