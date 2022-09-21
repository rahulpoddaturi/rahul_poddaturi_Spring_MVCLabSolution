package com.greatlearning.Lab.service;

import java.util.List;

import com.greatlearning.Lab.entity.Student;

public interface StudentService {
	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student theStudent);

	public void deleteById(int theId);


}
