package com.example.demo.BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Model.Topics;
import com.example.demo.Repository.EmployeeRespository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRespository repo;
	
	
	
//	public List<Course> findByTopicId(int topicId){
//		List<Course> list = new ArrayList<>();
//
////		Iterable<Course> s = repo.findByTopicsId(topicId);
//		Iterable<Course> s = repo.findAll();
//		s.forEach(a -> list.add(a));
//		return list;
//	}

	public List<Employee> getAll() {
//		List<Employee> list = new ArrayList<>();
//
//		Iterable<Employee> s = repo.findAll();
//		s.forEach(a -> list.add(a));
		return repo.findAll();
	}

	public void send(Employee course) {
	
		repo.save(course);
	}

	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public Employee findById(String id) {
		
		return repo.findById(id).get();
//		Optional<Employee> byId = repo.findById(id);
//		if(byId.isPresent()) {
//			return byId.get();
//		}
//		return new Employee();
	}

	public void update(Employee course) {
//	Topics topics=new Topics();
//	topics.setId(course.getTopics().getId());    //getting id to be updated and putting in new instace of topic
//	course.setTopics(topics);                      //  updating topic of course object to be saved
	repo.save(course);
	
		
	}
	

	
	
	
	
}
