package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Document
public class InterceptorData {
@org.springframework.data.annotation.Id
 private String Id;	
 private String methodType;
 private String contentType;
 private String URI ;
 private int status;
 
 
 
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getMethodType() {
	return methodType;
}
public void setMethodType(String methodType) {
	this.methodType = methodType;
}
public String getContentType() {
	return contentType;
}
public void setContentType(String contentType) {
	this.contentType = contentType;
}
public String getURI() {
	return URI;
}
public void setURI(String uRI) {
	URI = uRI;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public InterceptorData(String id, String methodType, String contentType, String uRI, int status) {
	super();
	Id = id;
	this.methodType = methodType;
	this.contentType = contentType;
	URI = uRI;
	this.status = status;
}
public InterceptorData() {
	super();
	// TODO Auto-generated constructor stub
}

 


}
