package com.truYum.app.persitant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "contact_generator")
    @SequenceGenerator(name = "contact_generator", sequenceName = "contact_seq", allocationSize = 1)
	private int id;
	private String name;
	private String userId;
	private String password;
	private String location;
	private String contactNo;
	public Customer(String name, String userId, String password,String location,String contactNo) {
		super();
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.location=location;
		this.contactNo=contactNo;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", userId=" + userId + ", password=" + password + ", location="
				+ location + ", contactNo=" + contactNo + "]";
	}
	
}
