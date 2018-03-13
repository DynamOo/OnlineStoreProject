package com.swe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.swe.entities.Administrator;

public interface AdminRepository extends CrudRepository<Administrator, Integer> {

}
