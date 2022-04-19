package com.portal.studentportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Attachment {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private int id;
	  private String name;
	  private String type;
	  @Lob
	  private byte[] data;
	  
	  public Attachment()
	  {
		  
	  }
	  
	  public Attachment(String name, String type) {
			super();
			this.name = name;
			this.type = type;
//			this.data = data;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
