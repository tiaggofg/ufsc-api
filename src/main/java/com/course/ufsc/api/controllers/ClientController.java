package com.course.ufsc.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.ufsc.api.dtos.ClientDto;
import com.course.ufsc.api.entities.ClientModel;
import com.course.ufsc.api.services.ClientService;

@RestController
@RequestMapping("/cliente")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping
	public ResponseEntity<? extends Object> saveClient(@RequestBody @Valid ClientDto clientDto) {
		if (clientService.existsName(clientDto.getName()) || clientService.existsEmail(clientDto.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: this name or email already registred!");
		}
		var client = new ClientModel();
		BeanUtils.copyProperties(clientDto, client);
		clientService.save(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(client);  
	}
	
	@GetMapping
	public ResponseEntity<List<ClientModel>> getAllClients() {
		var clients = clientService.getAllClients();
		return ResponseEntity.status(HttpStatus.OK).body(clients);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<? extends Object> getOneClient(@PathVariable(value = "id") Long id) {
		if (!clientService.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
		}
		var client = clientService.getOneClient(id);
		return ResponseEntity.status(HttpStatus.OK).body(client);
	}

}
