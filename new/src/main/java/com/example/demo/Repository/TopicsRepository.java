package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Topics;
@Repository
public interface TopicsRepository  extends MongoRepository<Topics, Integer>{

		
}
