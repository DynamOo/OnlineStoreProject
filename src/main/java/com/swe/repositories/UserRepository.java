package com.swe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.swe.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
