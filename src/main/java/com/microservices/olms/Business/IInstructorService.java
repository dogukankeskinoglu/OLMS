package com.microservices.olms.Business;

import java.util.List;

import com.microservices.olms.Entities.Instructor;

public interface IInstructorService {
	List<Instructor> getAll();
	void add(Instructor instructor);
	void delete(Instructor instructor);
	void update(Instructor instructor);
	Instructor getById(int id);
}
