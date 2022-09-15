package com.course.ufsc.api.tests;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.ufsc.api.entities.ClientModel;
import com.course.ufsc.api.repositories.ClientRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public void run(String... args) {
		var c1 = new ClientModel("Obi Wan Kenobi", "kenobi@gmail.com", "49989013490", "@fjw0189");
		var c2 = new ClientModel("Darth Vader", "vader@imperio.com", "000000000", "$yxzW66");
		var c3 = new ClientModel("Mestre Yoda", "yoda@outlook.com", "7833097600", "&56kq9*Al");
		var c4 = new ClientModel("Luke Skywalker", "lukeo@gmail.com", "1102437992", "4hf6!Kh");
		
		clientRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
	}

}
