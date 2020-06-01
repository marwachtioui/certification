package com.addinn.certification.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addinn.certification.entities.Request;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.services.RequestService;

@RestController
@RequestMapping("/request")
@CrossOrigin("*")
public class RequestController {
	@Autowired
	private RequestService requestService;
	
	@PostMapping
	public MessageResponse addRequest(@RequestBody Request request) {
		return requestService.newRequest(request);
	}
	
	
	@GetMapping("/client/{id}")
	public List<Request> findByClient(@PathVariable Integer id) {
		return requestService.findByClient(id);
	}
}
