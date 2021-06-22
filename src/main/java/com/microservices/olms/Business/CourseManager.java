package com.microservices.olms.Business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.olms.DataAccess.ICourseDal;
import com.microservices.olms.Entities.Course;

@Service
public class CourseManager implements ICourseService{

	private ICourseDal courseDal;
	
	@Autowired
	public CourseManager(ICourseDal courseDal) {
		this.courseDal = courseDal;
	}

	@Override
	@Transactional
	public List<Course> getAll() {
		return courseDal.getAll();
	}

	@Override
	@Transactional
	public void add(Course course) {
		courseDal.add(course);
		
	}

	@Override
	@Transactional
	public void delete(Course course) {
		courseDal.delete(course);
		
	}

	@Override
	@Transactional
	public void update(Course course) {
		 courseDal.update(course);
		
	}

	@Override
	@Transactional
	public Course getById(int id) {
		return courseDal.getById(id);
	}
	
}
