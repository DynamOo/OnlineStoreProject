package com.swe.repositories;

import javax.transaction.Transactional;

import com.swe.entities.NormalUser;

@Transactional
public interface NormalUserRepository extends UsersBaseRepository<NormalUser> {

}

