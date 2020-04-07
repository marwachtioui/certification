package com.addinn.certification.services;

import java.util.List;

import com.addinn.certification.entities.Agency;
import com.addinn.certification.model.MessageResponse;

public interface AgencyService {

	public MessageResponse save(Agency agency);

	public MessageResponse update(Agency agency);

	public MessageResponse delete(Integer id);

	public Agency findById(Integer id);

	public List<Agency> findAll();

	public List<Agency> findbyIdCompany(Integer idCompany);

	
	
}
