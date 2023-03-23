package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;

public interface controllerService{

	public List<Course> getCourses();
	public Course putCourse(Course c);
	public List<Course> getCoursePlus(Object name);
	public void deleteCourse(int id);
}
