package com.microservices.olms.restAPI;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.olms.Business.IStudentGradeService;
import com.microservices.olms.Entities.StudentGrade;

@RestController
@RequestMapping("/api")
public class StudentGradeController {
	
	private IStudentGradeService studentGradeService;

	public StudentGradeController(IStudentGradeService studentGradeService) {
		this.studentGradeService = studentGradeService;
	}
	
	@GetMapping("/studentgrades")
	public List<StudentGrade> get(){
		return studentGradeService.getAll();
	}
	
	@PostMapping("/addstudentgrade")
	public void add(@RequestBody StudentGrade studentGrade) {
		studentGradeService.add(studentGrade);
	}
	
	@PostMapping("/deletestudentgrade")
	public void delete(@RequestBody StudentGrade studentGrade) {
		studentGradeService.delete(studentGrade);
	}
	
	@PostMapping("/updatestudentgrade")
	public void update(@RequestBody StudentGrade studentGrade) {
		studentGradeService.update(studentGrade);
	}
	
	@GetMapping("/studentgrades/{id}")
	public StudentGrade getById(@PathVariable int id) {
		return studentGradeService.getById(id);
	}
}
