package com.course.ufsc.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.ufsc.api.entities.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {

	boolean existsById(Long id);
	boolean existsByName(String name);
	boolean existsByEmail(String email);
	
}
