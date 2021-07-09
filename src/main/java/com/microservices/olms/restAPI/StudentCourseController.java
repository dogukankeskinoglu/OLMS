package com.microservices.olms.restAPI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.olms.Business.IStudentCourseService;
import com.microservices.olms.Entities.Student;
import com.microservices.olms.Entities.StudentCourse;

@RestController
@RequestMapping("/api")
public class StudentCourseController {
	
	private IStudentCourseService studentCourseService;

	public StudentCourseController(IStudentCourseService studentCourseService) {
		this.studentCourseService = studentCourseService;
	}
	
	@GetMapping("/studentcourses")
	public List<StudentCourse> get(){
		return studentCourseService.getAll();
	}
	
	@GetMapping("/coursestudents/{id}")
	public ArrayList<Student> getByCourseId(@PathVariable int id){
		List<StudentCourse> coursestudents= studentCourseService.getAll();
		ArrayList<Student> students = new ArrayList<Student>();
		for(int i=0;i<coursestudents.size();i++) {
			if(coursestudents.get(i).getCourse().getId()==id) {
				students.add(coursestudents.get(i).getStudent());
			}
		}
		return students;
	}
	
	@PostMapping("/addstudentcourse")
	public void add(@RequestBody StudentCourse studentCourse) {
		studentCourseService.add(studentCourse);
	}
	
	@PostMapping("/deletestudentcourse")
	public void delete(@RequestBody StudentCourse studentCourse) {
		studentCourseService.delete(studentCourse);
	}
	
	@PostMapping("/updatestudentcourse")
	public void update(@RequestBody StudentCourse studentCourse) {
		studentCourseService.update(studentCourse);
	}
	
	@GetMapping("/studentcourses/{id}")
	public StudentCourse getById(@PathVariable int id) {
		return studentCourseService.getById(id);
	}
}
