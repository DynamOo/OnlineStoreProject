package com.swe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.swe.entities.User;

@NoRepositoryBean // this annotation is used to prevent repository interfaces from being 
				  // picked up as candidates to end up as repository bean instances eventually. (Wallahy mfahem y3ny a bs it may help soon)
public interface UsersBaseRepository<T extends User> 
extends CrudRepository<T, Integer> {
	
	// All methods in this repository will be available in the UserRepository,
	// in the AdminRepository, in the SotreOwnerRepository, and in the NormalUserRepository.
	
	User findByEmail(String userMail);

}
