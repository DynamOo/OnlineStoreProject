package com.swe.repositories;

import javax.transaction.Transactional;

import com.swe.entities.User;

@Transactional
public interface UserRepository extends UsersBaseRepository<User> {
	
	//public User loginUser(int userID, String userPassword);
	
}
