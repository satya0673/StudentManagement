package com.example.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.student.model.Student;
import com.example.student.repo.StudentRepo;

@Service
public class StudentService {

	private  StudentRepo repository;
	
	 public StudentService(StudentRepo repository) {
	        this.repository = repository;
	    }

	    public Student createStudent(Student student) {
	        return repository.save(student);
	    }

	    public List<Student> getAllStudents() {
	        return repository.findAll();
	    }
	

	    public Student getStudentById(Long id) {
	        return repository.findById(id).orElse(null);
	    }

	    public Student updateStudent(Long id, Student student) {
	        Student existing = repository.findById(id).orElse(null);
	        if (existing != null) {
	            existing.setName(student.getName());
	            existing.setEmail(student.getEmail());
	            existing.setAge(student.getAge());
	            return repository.save(existing);
	        }
	        return null;
	    }

	    public void deleteStudent(Long id) {
	        repository.deleteById(id);
	    }
	
}
