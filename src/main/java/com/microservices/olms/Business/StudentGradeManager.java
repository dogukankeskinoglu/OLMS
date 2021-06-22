package com.microservices.olms.Business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.olms.DataAccess.IStudentGradeDal;
import com.microservices.olms.Entities.StudentGrade;

@Service
public class StudentGradeManager implements IStudentGradeService{

	private IStudentGradeDal studentGradeDal;
	
	@Autowired
	public StudentGradeManager(IStudentGradeDal studentGradeDal) {
		this.studentGradeDal = studentGradeDal;
	}

	@Override
	@Transactional
	public List<StudentGrade> getAll() {
		return studentGradeDal.getAll();
	}

	@Override
	@Transactional
	public void add(StudentGrade studentGrade) {
		studentGradeDal.add(studentGrade);
		
	}

	@Override
	@Transactional
	public void delete(StudentGrade studentGrade) {
		studentGradeDal.delete(studentGrade);
		
	}

	@Override
	@Transactional
	public void update(StudentGrade studentGrade) {
		studentGradeDal.update(studentGrade);
		
	}

	@Override
	@Transactional
	public StudentGrade getById(int id) {
		return studentGradeDal.getById(id);
	}

}
