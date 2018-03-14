package com.swe.repositories;

import javax.transaction.Transactional;

import com.swe.entities.StoreOwner;

@Transactional
public interface StoreOwnerRepository extends UsersBaseRepository<StoreOwner> {

}

