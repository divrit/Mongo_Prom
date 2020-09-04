package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.BusinessLogic.EmployeeService;
import com.example.demo.Model.Employee;

import io.micrometer.core.annotation.Timed;

@Controller
@ResponseBody
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService  service;
	

	@Timed(
			value="Divrit.getListOfCourses",
			histogram = true
			
			
			)
	@GetMapping
	 public List<Employee> getAll() {
	return service.getAll();
		
	}
	
	@GetMapping("{id}")
	 public Employee getOne(@PathVariable String id) {
	return service.findById(id);
		
	}
	
	@PostMapping
	 public void send(@RequestBody Employee course) {
	 service.send(course);
	}
	
	@PutMapping("/{id}")
	public void update(@RequestBody Employee course, @PathVariable String id) {
		course.setId(id);
		 service.update(course);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		service.delete(id);
	}
	
	

}
