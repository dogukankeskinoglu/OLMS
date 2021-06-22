package com.microservices.olms.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_grade")
public class StudentGrade {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "sc_id", referencedColumnName = "id")
	private StudentCourse studentCourse;
	
	@Column(name = "grade")
	private int grade;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StudentCourse getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(StudentCourse studentCourse) {
		this.studentCourse = studentCourse;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public StudentGrade() {
		
	}
	
	public StudentGrade(int id, StudentCourse studentCourse, int grade) {
		this.id = id;
		this.studentCourse = studentCourse;
		this.grade = grade;
	}

	
}
