package com.portal.studentportal.services;

import java.util.List;

import com.portal.studentportal.entities.Student;

public interface StudentService {

    List<Student> getAllStudent();

    Student getStudentById(int studentId);

    Student addStudent(Student student);

    Student updateStudent(Student student, int studentId);

    void deleteStudent(int studentId);

    Student findByUsername(String username, String password);

}
