package com.microservices.olms.Business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.olms.DataAccess.IStudentDal;
import com.microservices.olms.Entities.Student;

@Service
public class StudentManager implements IStudentService{

	
	private IStudentDal studentDal;
	
	@Autowired
	public StudentManager(IStudentDal studentDal) {
		this.studentDal = studentDal;
	}
	
	@Override
	@Transactional
	public List<Student> getAll() {
		return studentDal.getAll();
	}

	@Override
	@Transactional
	public void add(Student student) {
		
		studentDal.add(student);
		
	}
 
	@Override
	@Transactional
	public void delete(Student student) {
		studentDal.delete(student);
		
	}

	@Override
	@Transactional
	public void update(Student student) {
		studentDal.update(student);
		
	}

	@Override
	@Transactional
	public Student getById(int id) {
		return studentDal.getById(id);
	}

}
