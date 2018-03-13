package com.swe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id   // keda b2ollo en el-attribute elly b3dak hyb2a el-PRIMARY KEY fe el-table
    @GeneratedValue(strategy=GenerationType.AUTO)      // auto-increment
	protected int id;
	protected String firstName,
		   lastName,
		   email,
		   password,
		   address,
		   phoneNumber,
		   type; 		// admin, normal, owner
	protected int age;
	
	public User(int id, String firstName, String lastName, String email, String password, String address, String phoneNumber, String type, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.type = type;
		this.age = age;
	}
	
	public User() {
		super();
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.password = "";
		this.address = "";
		this.phoneNumber = "";
		this.type = "";
		this.age = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
