package com.addinn.certification.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.addinn.certification.entities.Client;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.services.ClientService;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientController {
	
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping
	public MessageResponse save(@RequestBody Client client) {
		return clientService.save(client);
		
	}
	
	@PutMapping
	public MessageResponse update(@RequestBody Client client) {
		return clientService.update(client);
	}
	
	@GetMapping
	public List<Client> findAll() {
		return clientService.findAll();
	}

	@GetMapping("/{id}")
	public Client findById(@PathVariable("id") Integer id) {
		return clientService.findById(id);
	}
	

}
