package com.microservices.olms.Business;

import java.util.List;

import com.microservices.olms.Entities.Student;
import com.microservices.olms.Entities.StudentCourse;

public interface IStudentCourseService {
	List<StudentCourse> getAll();
 	void add(StudentCourse studentCourse);
	void delete(StudentCourse studentCourse);
	void update(StudentCourse studentCourse);
	StudentCourse getById(int id);
	
}
