package com.microservices.olms.Business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.olms.DataAccess.IStudentCourseDal;
import com.microservices.olms.Entities.Student;
import com.microservices.olms.Entities.StudentCourse;

@Service
public class StudentCourseManager implements IStudentCourseService{
	
	private IStudentCourseDal studentCourseDal;
	
	@Autowired
	public StudentCourseManager(IStudentCourseDal studentCourseDal) {
		this.studentCourseDal = studentCourseDal;
	}

	@Override
	@Transactional
	public List<StudentCourse> getAll() {
		return studentCourseDal.getAll();
	}
	

	@Override
	@Transactional
	public void add(StudentCourse studentCourse) {
		studentCourseDal.add(studentCourse);
	}

	@Override
	@Transactional
	public void delete(StudentCourse studentCourse) {
		studentCourseDal.delete(studentCourse);
		
	}

	@Override
	@Transactional
	public void update(StudentCourse studentCourse) {
		studentCourseDal.update(studentCourse);
		
	}

	@Override
	@Transactional
	public StudentCourse getById(int id) {
		return studentCourseDal.getById(id);
	}

}
