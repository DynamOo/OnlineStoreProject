package com.swe.entities;

import javax.persistence.Entity;

@Entity
public class NormalUser extends User{

	public NormalUser() {
		super();
	}

	public NormalUser(int id, String firstName, String lastName, String email, String password, String address,
			String phoneNumber, String type, int age) {
		super(id, firstName, lastName, email, password, address, phoneNumber, type, age);
	}

}
