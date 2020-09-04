package com.example.demo.Model;


//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.ManyToOne;

import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Document
public class Employee {
//	@javax.persistence.Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@org.springframework.data.annotation.Id
	private String _id;
	private String Name;
	private String Description;

	
	public Employee(String id, String name, String description) {
		super();
		_id = id;
		Name = name;
		Description = description;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
