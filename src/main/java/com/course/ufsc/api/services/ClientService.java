package com.course.ufsc.api.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
	
	public boolean existsName(String name) {
		return clientRepository.existsByName(name);
	}
	
	public boolean existsEmail(String email) {
		return clientRepository.existsByEmail(email);
	}
	
	@Transactional
	public ClientModel save(ClientModel client) {
		return clientRepository.save(client);
	}
	
}
