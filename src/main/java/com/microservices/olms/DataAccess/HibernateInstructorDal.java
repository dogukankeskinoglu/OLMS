package com.microservices.olms.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservices.olms.Entities.Instructor;

@Repository
public class HibernateInstructorDal implements IInstructorDal{
	
	// JPA injection
	private EntityManager entityManager;
		
	@Autowired
	public HibernateInstructorDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public List<Instructor> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Instructor> instructors = session.createQuery("from Instructor", Instructor.class).getResultList();
		return instructors;
	}

	@Override
	@Transactional
	public void add(Instructor instructor) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(instructor);
	}

	@Override
	@Transactional
	public void delete(Instructor instructor) {
		Session session = entityManager.unwrap(Session.class);
		Instructor instructorToDelete = session.get(Instructor.class, instructor.getId());
		session.delete(instructorToDelete);
		
	}

	@Override
	@Transactional
	public void update(Instructor instructor) {
		
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(instructor);
	}

	@Override
	@Transactional
	public Instructor getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Instructor instructor = session.get(Instructor.class, id);
		return instructor;
	}

}
