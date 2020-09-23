package com.example.demo.Interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Employee;
import com.example.demo.Model.InterceptorData;
import com.example.demo.Model.Topics;
import com.example.demo.Repository.InterceptorRepo;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;

@Component
public class Handle implements HandlerInterceptor {
		
		@Autowired
		private InterceptorRepo repo;
		@Autowired 
		private MeterRegistry registry;
		

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String methodType=request.getMethod();
		String contentType = request.getContentType();
		StringBuffer URL = request.getRequestURL();
	    String URI = request.getRequestURI();
		System.out.println("I am pre with method "+methodType);
		System.out.println("I am pre with contentType "+contentType);
		System.out.println("URL "+URL);
		System.out.println("URI "+URI);
		int status = response.getStatus();
		System.out.println("status"+status);
	
		
		
		InterceptorData data=new InterceptorData();
		data.setContentType(contentType);
		data.setMethodType(methodType);
		data.setStatus(status);
		data.setURI(URI);
		repo.save(data);
		
		return true;
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("I am post");
		
	}
	
	  
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
//		
	
	        List<Tag> tags = new ArrayList<>();
	        tags.add(Tag.of("application.method.name", request.getMethod()));
	        tags.add(Tag.of("application.status.code", Integer.toString(response.getStatus())));
	       
		
	    
		// TODO Auto-generated method stub
		String methodType=request.getMethod();
		String contentType = request.getContentType();
		StringBuffer URL = request.getRequestURL();
	    String URI = request.getRequestURI();
		System.out.println("after   "+methodType);
		System.out.println("after "+contentType);
		System.out.println("after"+URL);
		System.out.println("after  URI "+URI);
		int status = response.getStatus();
		String header=response.getHeader(contentType);
		System.out.println("after    status"+status);
		System.out.println("after    header"+header);
	
		
		System.out.println("I am after request and response is done");
	}
}
