package com.microservices.olms.Business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.olms.DataAccess.IInstructorDal;
import com.microservices.olms.Entities.Instructor;

@Service
public class InstructorManager implements IInstructorService{
	
	private IInstructorDal instructorDal;
	
	@Autowired
	public InstructorManager(IInstructorDal instructorDal) {
		this.instructorDal = instructorDal;
	}

	@Override
	@Transactional
	public List<Instructor> getAll() {
		return instructorDal.getAll();
	}

	@Override
	@Transactional
	public void add(Instructor instructor) {
		instructorDal.add(instructor);
		
	}

	@Override
	@Transactional
	public void delete(Instructor instructor) {
		instructorDal.delete(instructor);
		
	}

	@Override
	@Transactional
	public void update(Instructor instructor) {
		instructorDal.update(instructor);
		
	}

	@Override
	@Transactional
	public Instructor getById(int id) {
		return instructorDal.getById(id);
	}
	
	
}
