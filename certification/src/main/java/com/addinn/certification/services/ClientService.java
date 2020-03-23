package com.addinn.certification.services;

import java.util.List;

import com.addinn.certification.entities.Client;
import com.addinn.certification.model.MessageResponse;

public interface ClientService {

	public MessageResponse save(Client client);

	public MessageResponse update(Client client);

	List<Client> findAll();

    Client findById(Integer id);
	

}
