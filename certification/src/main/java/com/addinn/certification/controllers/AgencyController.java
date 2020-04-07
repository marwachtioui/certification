package com.addinn.certification.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addinn.certification.entities.Agency;
import com.addinn.certification.entities.Company;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.services.AgencyService;

@RestController
@RequestMapping("/agency")
@CrossOrigin("*")
public class AgencyController {

	@Autowired
	private AgencyService agencyService;

	@PostMapping
	public MessageResponse save(@RequestBody Agency agency) {
		return agencyService.save(agency);

	}

	@PutMapping
	public MessageResponse update(@RequestBody Agency agency) {
		return agencyService.update(agency);

	}

	@GetMapping("/findByCompany/{idCompany}")
	public List<Agency> findByCompany(@PathVariable Integer idCompany) {
		return agencyService.findbyIdCompany(idCompany);
	}

	@GetMapping("/{id}")
	public Agency findById(@PathVariable Integer id) {
		return agencyService.findById(id);
	}

	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable Integer id) {
		return agencyService.delete(id);

	}

}
