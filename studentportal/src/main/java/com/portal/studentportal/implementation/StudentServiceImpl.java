package com.portal.studentportal.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.studentportal.entities.Student;
import com.portal.studentportal.repository.StudentRepository;
import com.portal.studentportal.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudent() {
		return (List<Student>) studentRepository.findAll();

	}

	@Override
	public Student getStudentById(int studentId) {
		return studentRepository.findById(studentId).get();
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student, int studentId) {
		Student s = studentRepository.findById(studentId).get();
		s.setRollNo(student.getRollNo());
		s.setFname(student.getFname());
		s.setLname(student.getLname());
		s.setEmail(student.getEmail());
		s.setUsername(student.getUsername());
		s.setPassword(student.getPassword());
		s.setConfirmPassword(student.getConfirmPassword());

		return studentRepository.save(s);
	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}

	@Override
	public Student findByUsername(String username, String password) {
		List<Student> reg = studentRepository.getByUsername(username, password);
		System.out.println("reg" + reg);
		if (!reg.isEmpty()) {
			return reg.get(0);
		}
		return reg.get(0);
	}

}
