package com.microservices.olms.DataAccess;

import java.util.List;

import com.microservices.olms.Entities.StudentCourse;

public interface IStudentCourseDal {
	List<StudentCourse> getAll();
	void add(StudentCourse studentCourse);
	void delete(StudentCourse studentCourse);
	void update(StudentCourse studentCourse);
	StudentCourse getById(int id);
}
