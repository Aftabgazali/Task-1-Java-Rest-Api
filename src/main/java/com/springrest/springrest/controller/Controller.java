package com.springrest.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.controllerService;

@RestController
public class Controller {

	@Autowired
	private controllerService controllerService;
	@GetMapping("/home")
	public String home()
	{
		return "Welcome this is Home Page";
	}
	
	// get the courses
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		// ask the service
		return this.controllerService.getCourses();
	}
	
	// pass the path variable i.e. the course id you want to search
	// the url would be /courses/{dynamic id}, anything present in {}would change.
	@PostMapping("/courses")
	public Course putCourse(@RequestBody Course c)
	{
		return this.controllerService.putCourse(c);
	}
	@GetMapping("/courses/{name}")
	public ResponseEntity<List<Course>> getCoursePlus(@PathVariable Object name)
	{
		List<Course> courses = this.controllerService.getCoursePlus(name);
		if(courses.size() <= 0)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.of(Optional.of(courses));
	}
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable int courseId)
	{
		try {
		this.controllerService.deleteCourse(courseId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	catch(Exception e)
	{
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
}
