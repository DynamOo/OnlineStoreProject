package com.swe.repositories;

import javax.transaction.Transactional;

import com.swe.entities.Collaborator;

@Transactional
public interface CollaboratorRepository extends UsersBaseRepository<Collaborator> {
	
}