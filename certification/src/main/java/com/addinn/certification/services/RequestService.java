package com.addinn.certification.services;

import java.util.List;

import com.addinn.certification.entities.Request;
import com.addinn.certification.model.MessageResponse;

public interface RequestService {

	public MessageResponse newRequest(Request request);
	public List<Request> findByClient(Integer id);
}
