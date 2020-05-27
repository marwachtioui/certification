package com.addinn.certification.controllers;

import com.addinn.certification.entities.Request;
import com.addinn.certification.model.MessageResponse;

public interface RequestService {

	public MessageResponse newRequest(Request request);
}
