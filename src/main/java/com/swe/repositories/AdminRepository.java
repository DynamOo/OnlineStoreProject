package com.swe.repositories;

import javax.transaction.Transactional;

import com.swe.entities.Administrator;

@Transactional
public interface AdminRepository extends UsersBaseRepository<Administrator> {

}
