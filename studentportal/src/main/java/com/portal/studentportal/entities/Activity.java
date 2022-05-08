package com.portal.studentportal.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.swing.text.Document;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
public class Activity {


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String Notice;
	private String Examdetails;
	private String Name;
	@JsonFormat(pattern ="yyyy-MM-dd", shape= Shape.STRING)
	@CreationTimestamp
	private Date date;
	
	@ManyToOne
    @JoinColumn(name = "attId")
    private Attachment attachment;
	
	
	
	public Activity()
	{
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNotice() {
		return Notice;
	}



	public void setNotice(String notice) {
		Notice = notice;
	}



	public String getExamdetails() {
		return Examdetails;
	}



	public void setExamdetails(String examdetails) {
		Examdetails = examdetails;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Attachment getAttachment() {
		return attachment;
	}



	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}



	public Activity(int id, String notice, String examdetails, String name, Date date, Attachment attachment) {
		super();
		this.id = id;
		Notice = notice;
		Examdetails = examdetails;
		Name = name;
		this.date = date;
		this.attachment = attachment;
	}
}
