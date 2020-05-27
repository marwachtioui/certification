package com.addinn.certification.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addinn.certification.entities.Request;
import com.addinn.certification.model.MessageResponse;

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
}
