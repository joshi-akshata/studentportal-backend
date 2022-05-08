package com.portal.studentportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Attachment {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;
	  private String name;
	  private String type;
	  @Lob
	  private byte[] data;
	  
	  @ManyToOne
	  @JoinColumn(name = "activityId")
	  private Activity activity;
	  
	  public Attachment()
	  {
		  
	  }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Attachment(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	  
	 
}
