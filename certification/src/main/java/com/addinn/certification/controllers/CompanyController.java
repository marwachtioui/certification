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
import com.addinn.certification.entities.Company;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.services.CompanyService;

@RestController
@RequestMapping("/company")
@CrossOrigin("*")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping
	public MessageResponse save(@RequestBody Company company) {
		return companyService.save(company);
	}

	@PutMapping
	public MessageResponse update(@RequestBody Company company) {
		return companyService.update(company);

	}

	@GetMapping
	public List<Company> findAll() {
		return companyService.findAll();
	}
	
	@GetMapping("/{id}")
	public Company findById(@PathVariable Integer id) {
		return companyService.findById(id);
	}

	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable Integer id) {
		return companyService.delete(id);

	}

}
