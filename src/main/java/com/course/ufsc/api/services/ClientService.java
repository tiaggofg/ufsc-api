package com.course.ufsc.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.ufsc.api.entities.ClientModel;
import com.course.ufsc.api.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public List<ClientModel> getAllClients() {
		return clientRepository.findAll();
	}
	
	public Optional<ClientModel> getOneClient(Long id) {
		return clientRepository.findById(id);
	}
	
	public boolean existsById(Long id) {
		return clientRepository.existsById(id);
	}
	
}
