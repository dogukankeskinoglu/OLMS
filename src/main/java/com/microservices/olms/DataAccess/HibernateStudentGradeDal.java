package com.microservices.olms.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservices.olms.Entities.StudentGrade;

@Repository
public class HibernateStudentGradeDal implements IStudentGradeDal{
	
	private EntityManager entityManager;

	@Autowired
	public HibernateStudentGradeDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<StudentGrade> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<StudentGrade> studentGrades = session.createQuery("from StudentGrade", StudentGrade.class).getResultList();
		return studentGrades;
	}

	@Override
	@Transactional
	public void add(StudentGrade studentGrade) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(studentGrade);
		
	}
	

	@Override
	@Transactional
	public void delete(StudentGrade studentGrade) {
		Session session = entityManager.unwrap(Session.class);
		StudentGrade studentGradeToDelete = session.get(StudentGrade.class, studentGrade.getId());
		session.delete(studentGradeToDelete);
		
	}

	@Override
	@Transactional
	public void update(StudentGrade studentGrade) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(studentGrade);
		
	}

	@Override
	@Transactional
	public StudentGrade getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		StudentGrade studentGrade = session.get(StudentGrade.class, id);
		return studentGrade;
	}
}
