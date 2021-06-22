package com.microservices.olms.DataAccess;

import java.util.List;

import com.microservices.olms.Entities.Course;


public interface ICourseDal {
	List<Course> getAll();
	void add(Course course);
	void delete(Course course);
	void update(Course course);
	Course getById(int id);

}
