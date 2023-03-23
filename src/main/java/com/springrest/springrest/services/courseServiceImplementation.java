package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class courseServiceImplementation implements controllerService{

	List<Course> course;
	public courseServiceImplementation()
	{
		course = new ArrayList<>();
		course.add(new Course("centos",123, "java","django"));
		course.add(new Course("pentos",456, "java","springBoot"));
		
		
	}
	public List<Course> getCourses() {
		
		return course;
	}
//	@Override
//	public Course getCourse(int id) {
//		// TODO Auto-generated method stub
//	
//		Course c = null;
//		for(Course subject : course)
//		{
//			if(subject.getId() == id)
//			{
//				c = subject;
//			}
//		}
//		return c;
//	}
	@Override
	public Course putCourse(Course c) {
		course.add(c);
		return c;
	}
	@Override
	public List<Course> getCoursePlus(Object name) {
		List<Course> p = new ArrayList<>();
		String filter = name.toString();
		if(filter.contains("1") || filter.contains("2")|| filter.contains("5") || filter.contains("3"))
		{
			int id = Integer.parseInt(name.toString());
			for(Course subject : course)
			{
				if(subject.getId() == id)
				{
					p.add(subject);
				}
			}
		}
			for(Course cour : course)
			{
				if(cour.getName().equals(name))
				{
					p.add(cour);
				}
			}
		return p;
	}
	@Override
	public void deleteCourse(int id) {
		course = this.course.stream().filter(e->e.getId() != id).collect(Collectors.toList());
		
	}
	}

