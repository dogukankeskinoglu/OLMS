package com.microservices.olms.DataAccess;

import java.util.List;

import com.microservices.olms.Entities.StudentGrade;

public interface IStudentGradeDal {
	List<StudentGrade> getAll();
	void add(StudentGrade studentGrade);
	void delete(StudentGrade studentGrade);
	void update(StudentGrade studentGrade);
	StudentGrade getById(int id);
}
