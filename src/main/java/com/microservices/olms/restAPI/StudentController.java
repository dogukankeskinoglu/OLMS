package com.microservices.olms.restAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.olms.Entities.Student;
import com.microservices.olms.Business.IStudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	// Injection
	private IStudentService studentService;
	
	@Autowired
	public StudentController(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("")
	public String welcome() {
		return "Welcome to the OLMS!";
	}
	
	@GetMapping("/students")
	public List<Student> get(){
		return studentService.getAll();
	}
	
	@PostMapping("/addstudent")
	public void add(@RequestBody Student student) {
		studentService.add(student);
	}
	
	@PostMapping("/updatestudent")
	public void update(@RequestBody Student student) {
		studentService.update(student);
	}
	
	@PostMapping("/deletestudent")
	public void delete(@RequestBody Student student) {
		studentService.delete(student);
	}
	
	@GetMapping("/students/{id}")
	public Student getById(@PathVariable int id) {
		return studentService.getById(id);
	}
}
