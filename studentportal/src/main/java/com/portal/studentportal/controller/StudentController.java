package com.portal.studentportal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.studentportal.entities.Student;
import com.portal.studentportal.services.StudentService;
import com.portal.studentportal.implementation.*;

@RestController
@CrossOrigin("*")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@GetMapping("/student")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@GetMapping("/student/{studentId}")
	public Student getStudentById(@PathVariable(name = "studentId") int studentId) {
		return studentService.getStudentById(studentId);
	}

	@PostMapping("/student")
	public Student addStudent(@Valid @RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@PutMapping("/student/{studentId}")
	public Student updateStudent(@PathVariable("studentId") int studentId, @Valid @RequestBody Student student) {
		return studentService.updateStudent(student, studentId);
	}

	@DeleteMapping("/student/{studentId}")
	public void deleteStudent(@PathVariable(name = "studentId") int studentId) {
		studentService.deleteStudent(studentId);
	}

}
