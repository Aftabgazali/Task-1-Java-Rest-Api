package com.springrest.springrest.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Course")
public class Course {
	private String name;
	private int id;
	private String language;
	private String framework;
	
	public Course(String name, int i, String language, String framework) {
		super();
		this.name = name;
		this.id = i;
		this.language = language;
		this.framework = framework;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", id=" + id + ", language=" + language + ", framework=" + framework + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}

}
