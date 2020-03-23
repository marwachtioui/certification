package com.addinn.certification.services;

import java.util.List;

import com.addinn.certification.entities.Company;
import com.addinn.certification.model.MessageResponse;

public interface CompanyService {
	
	public MessageResponse save(Company company);
	public MessageResponse update(Company company);
	public MessageResponse delete(Integer id);
	public List<Company> findAll();
	public Company findById(Integer id);

}
