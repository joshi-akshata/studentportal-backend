package com.portal.studentportal.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portal.studentportal.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("select r from Student r where r.username=:username and r.password=:password")
	public List<Student> getByUsername(@Param("username") String username,@Param("password") String password);

}
