package com.microservices.olms.restAPI;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.olms.Business.ICourseService;
import com.microservices.olms.Entities.Course;

@RestController
@RequestMapping("/api")
public class CourseController {
	
	private ICourseService courseService;

	public CourseController(ICourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping("/courses")
	public List<Course> get(){
		return courseService.getAll();
	}
	
	@PostMapping("/addcourse")
	public void add(@RequestBody Course course) {
		courseService.add(course);
	}
	
	@PostMapping("/deletecourse")
	public void delete(@RequestBody Course course) {
		courseService.delete(course);
	}
	
	@PostMapping("/updatecourse")
	public void update(@RequestBody Course course) {
		courseService.update(course);
	}
	
	@GetMapping("/courses/{id}")
	public Course getById(@PathVariable int id) {
		return courseService.getById(id);
	}
}
