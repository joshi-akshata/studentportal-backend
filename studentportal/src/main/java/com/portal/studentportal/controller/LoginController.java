package com.portal.studentportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.studentportal.entities.Student;
import com.portal.studentportal.implementation.*;

@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@PostMapping("/login")
	public Student findByUsername(@RequestBody Student student) {
		try {
			return studentServiceImpl.findByUsername(student.getUsername(), student.getPassword());
		} catch (Exception e) {
			return null;
		}

	}
}
