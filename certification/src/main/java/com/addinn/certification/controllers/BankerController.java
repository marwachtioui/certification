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

import com.addinn.certification.entities.Banker;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.services.BankerService;

@RestController
@RequestMapping("/banker")
@CrossOrigin("*")
public class BankerController {
	@Autowired
	private BankerService bankerService;

	@PostMapping
	public MessageResponse save(@RequestBody Banker banker) {
		return bankerService.save(banker);
	}
	
	@PutMapping
	public MessageResponse update(@RequestBody Banker banker) {
		return bankerService.update(banker);
	}

	@GetMapping
	public List<Banker> findAll() {
		return bankerService.findAll();
	}

	@GetMapping("/{id}")
	public Banker findById(@PathVariable("id") Integer id) {
		return bankerService.findById(id);
	}
}
