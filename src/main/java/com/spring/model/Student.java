package com.spring.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// @Document -> will create a student collection and manage documents in that collection formatted
//				like this class
@Document
public class Student {

	// _id value that mongo generates
	@Id
	private String id;

	private String name;
	private Double gpa;
	private String major;
	private Address address;

	public Student() {

	}

	public Student(String id, String name, Double gpa, String major, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		this.major = major;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + ", major=" + major + ", address=" + address
				+ "]";
	}

}
