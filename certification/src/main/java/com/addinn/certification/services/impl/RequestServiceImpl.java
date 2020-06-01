package com.addinn.certification.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addinn.certification.entities.Client;
import com.addinn.certification.entities.Request;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.repositories.CheckBookRepository;
import com.addinn.certification.repositories.RequestRepository;
import com.addinn.certification.services.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestRepository requestRepository;
	@Autowired
	private CheckBookRepository checkBookRepository;

	@Override
	public MessageResponse newRequest(Request request) {

		
		boolean exist = checkBookRepository.existsByNumCheque(request.getCheckbook().getNumCheque());
		
		if(exist) {
			return new MessageResponse(false, "Demande déjà affectée");
		}
		
		
		
		request.setDate(new Date());
		request.setEtat("En attente");
		request.getCheckbook().setRequest(request);
		requestRepository.save(request);

		return new MessageResponse(true, "Opération efféctuée avec succès");
	}

	@Override
	public List<Request> findByClient(Integer id) {
		Client clt = new Client();
		clt.setId(id);
		return requestRepository.findByClient(clt);
	}

}
