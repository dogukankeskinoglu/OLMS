package com.microservices.olms.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservices.olms.Entities.Course;
import com.microservices.olms.Entities.StudentCourse;

@Repository
public class HibernateStudentCourseDal implements IStudentCourseDal{

	// JPA injection
	private EntityManager entityManager;
			
	@Autowired
	public HibernateStudentCourseDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	

	@Override
	@Transactional
	public List<StudentCourse> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<StudentCourse> studentCourses = session.createQuery("from StudentCourse", StudentCourse.class).getResultList();
		return studentCourses;
	}

	@Override
	@Transactional
	public void add(StudentCourse studentCourse) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(studentCourse);
		
	}

	@Override
	@Transactional
	public void delete(StudentCourse studentCourse) {
		Session session = entityManager.unwrap(Session.class);
		StudentCourse studentCourseToDelete = session.get(StudentCourse.class, studentCourse.getId());
		session.delete(studentCourseToDelete);
	}

	@Override
	@Transactional
	public void update(StudentCourse studentCourse) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(studentCourse);
		
	}



	@Override
	@Transactional
	public StudentCourse getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		StudentCourse studentCourse = session.get(StudentCourse.class, id);
		return studentCourse;
	}


}
