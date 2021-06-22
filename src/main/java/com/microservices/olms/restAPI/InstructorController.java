package com.microservices.olms.restAPI;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.olms.Business.IInstructorService;
import com.microservices.olms.Entities.Instructor;
@RestController
@RequestMapping("/api")
public class InstructorController {
	
	private IInstructorService instructorService;

	public InstructorController(IInstructorService instructorService) {
		this.instructorService = instructorService;
	}
	
	@GetMapping("/instructors")
	public List<Instructor> get(){
		return instructorService.getAll();
	}
	
	@PostMapping("/addinstructor")
	public void add(@RequestBody Instructor instructor) {
		instructorService.add(instructor);
	}
	
	@PostMapping("/deleteinstructor")
	public void delete(@RequestBody Instructor instructor) {
		instructorService.delete(instructor);
	}
	
	@PostMapping("/updateinstructor")
	public void update(@RequestBody Instructor instructor) {
		instructorService.update(instructor);
	}
	
	@GetMapping("/instructors/{id}")
	public Instructor getById(@PathVariable int id) {
		return instructorService.getById(id);
	}
}
