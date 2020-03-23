package com.addinn.certification.services;

import java.util.List;

import com.addinn.certification.entities.Banker;
import com.addinn.certification.model.MessageResponse;

public interface BankerService {

	MessageResponse save(Banker banker);

	MessageResponse update(Banker banker);


	List<Banker> findAll();

	Banker findById(Integer id);

}
