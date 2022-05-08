package com.portal.studentportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String rollNo;
	private String fname;

	private String lname;
	
	private String Email;
	
	private String username;

	private String password;
	private String ConfirmPassword;
	
	@ManyToOne
    @JoinColumn(name = "attId")
    private Attachment attachment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public Student(int id, String rollNo, String fname, String lname, String email, String username, String password,
			String confirmPassword, Attachment attachment) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.fname = fname;
		this.lname = lname;
		Email = email;
		this.username = username;
		this.password = password;
		ConfirmPassword = confirmPassword;
		this.attachment = attachment;
	}
	
	
	public Student()
	{
		
	}
	
	
}
