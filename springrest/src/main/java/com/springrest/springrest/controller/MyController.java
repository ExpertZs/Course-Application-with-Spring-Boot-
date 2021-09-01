package com.springrest.springrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseServices;

@RestController
public class MyController {
	
	
	
	@Autowired
	public CourseServices courseService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to courses Application";
	}
	
	@GetMapping("/course")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
		
	}
	
	@GetMapping("/course/{CourseId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public Course getCourse(@PathVariable String CourseId){
		return this.courseService.getCourse(Long.parseLong(CourseId));
		
	}
	
	@PostMapping(path = "/course" , consumes = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public Course getCourse(@RequestBody Course course){
		return this.courseService.addCourse(course);
		
	} 
	
	
	
	@DeleteMapping( "/course/{CourseId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String CourseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(CourseId));
			return new ResponseEntity <>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity <>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	} 
	
	
	@PutMapping("/course/{CourseId}")	
	@CrossOrigin(origins = "http://localhost:3000")
		public Course updateCourse(@RequestBody Course course){
		return this.courseService.updateCourse(course);
	}
	
	

}
