package com.portal.studentportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.studentportal.entities.Activity;
import com.portal.studentportal.entities.Student;
import com.portal.studentportal.services.ActivityService;
import com.portal.studentportal.services.StudentService;
import com.portal.studentportal.services.StudentServiceImpl;




@RestController
@CrossOrigin("*")
public class MyController {
	
	@Autowired
	private  StudentService studentService;
	
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	
		    @GetMapping("/student")
		    public List<Student> getAllStudent()
		       {
		       
		           return studentService.getAllStudent();
		        }
		 
	
			 @GetMapping("/student/{studentId}")
			 public Student getStudentById(@PathVariable(name = "studentId") int studentId) 
			     {
			         return studentService.getStudentById(studentId);
			        
			    }
	 

	        @PostMapping("/student")
	        public Student  addStudent(@RequestBody Student student)
	        {
		      return studentService.addStudent(student);
		        

	        }
	 
	   
	        @PutMapping("/student/{studentId}")
	        public Student updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student)
	        {
	            
	            	return studentService.updateStudent(student, studentId);
	        }
	        
	
	       
	        @DeleteMapping("/student/{studentId}")
	        public void deleteStudent(@PathVariable(name = "studentId") int studentId)
	        {
	              studentService.deleteStudent(studentId);
	               
	        }
	        
	        
	        
	        @GetMapping("/activity")
		    public List<Activity> getAllActivity()
		       {
		       
		           return activityService.getAllActivity();
		        }
		 
	
	        @GetMapping("/activity/{activityId}")
			public Activity getActivityById(@PathVariable(name = "activityId") int activityId) 
			     {
			         return activityService.getActivityById(activityId);
			        
			    }
	 

	        @PostMapping("/activity")
	        public Activity  addActivity(@RequestBody Activity activity)
	        {
		      return activityService.addActivity(activity);
		        

	        }
	 
	   
	        @PutMapping("/activity/{activityId}")
	        public Activity updateActivity( @PathVariable("activityId") int activityId, @RequestBody Activity activity)
	        {
	            
	        	    System.out.println("In controller" + activity);
	            	return activityService.updateActivity(activity, activityId);
	        }
	        
	
	       
	        @DeleteMapping("/activity/{activityId}")
	        public void deleteActivity(@PathVariable(name = "activityId") int activityId)
	        {
	              activityService.deleteActivity(activityId);
	               
	        }
	        
	        
	        @PostMapping("/login")
		      public Student findByUsername(@RequestBody Student student) 
		      {
		    	 try {
		    	 return studentServiceImpl.findByUsername(student.getUsername(),student.getPassword());
		    	 }
		    	 catch(Exception e) {
		    		 return null;
		    	 }
		    	 
		      }


}
