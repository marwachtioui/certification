package com.addinn.certification.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	public void store(MultipartFile file);

	public Resource loadFile(String filename);
}
