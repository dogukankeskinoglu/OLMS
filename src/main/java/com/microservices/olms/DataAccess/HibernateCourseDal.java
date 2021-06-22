package com.microservices.olms.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservices.olms.Entities.Course;

@Repository
public class HibernateCourseDal implements ICourseDal{
	
	// JPA injection
	private EntityManager entityManager;
	
	@Autowired
	public HibernateCourseDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Course> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Course> courses = session.createQuery("from Course", Course.class).getResultList();
		return courses;
	}

	@Override
	public void add(Course course) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(course);
	}

	@Override
	public void delete(Course course) {
		Session session = entityManager.unwrap(Session.class);
		Course courseToDelete = session.get(Course.class, course.getId());
		session.delete(courseToDelete);
		
	}

	@Override
	public void update(Course course) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(course);
		
	}

	@Override
	public Course getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Course course = session.get(Course.class, id);
		return course;
	}
	
}
