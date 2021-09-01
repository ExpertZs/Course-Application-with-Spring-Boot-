package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;

public interface CourseServices {
	
	
	public List<Course> getCourses();
	
	public Course getCourse(long CourseId);
	
	public Course addCourse(Course course);

	public void deleteCourse(long CourseId);

	public Course updateCourse(Course course);
	

}
