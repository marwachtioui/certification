package com.addinn.certification.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.addinn.certification.model.MessageResponse;

public interface StorageService {

	public MessageResponse store(MultipartFile file);

	public Resource loadFile(String filename);
}
