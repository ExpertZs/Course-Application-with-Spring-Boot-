package com.springrest.springrest.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseServices {

	// List<Course> list;
	
	@Autowired
	private CourseDao courseDao;
	 
	
	 public CourseServiceImpl() {
		// list = new ArrayList<>();
		 //list.add(new Course(123,"Java Core", "This is core Java"));
		 //list.add(new Course(124,"Java Spring Boot", "This is Rest api using spring boot"));
		 
	 }
	 
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long parseLong) {
		
		Course entity =courseDao.findById(parseLong).get();
		
		
		return entity;	
		}

	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		
		courseDao.save(course);
		
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		//list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Course entity =courseDao.getById(parseLong);
		
		courseDao.delete(entity);
		
	}

	@Override
	public Course updateCourse(Course course) {
		
		//list.forEach(e ->{
			//if(e.getId() == course.getId()) {
				//e.setTitle(course.getTitle());
				//e.setDescription(course.getDescription());
			//}
	//	});
		
		courseDao.save(course);
		return course;
	}
	

}
