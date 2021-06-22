package com.microservices.olms.Business;

import java.util.List;

import com.microservices.olms.Entities.Student;

public interface IStudentService {
	List<Student> getAll();
	void add(Student student);
	void delete(Student student);
	void update(Student student);
	Student getById(int id);
}
