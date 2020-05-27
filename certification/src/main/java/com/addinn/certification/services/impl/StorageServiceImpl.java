package com.addinn.certification.services.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.services.StorageService;

@Service
public class StorageServiceImpl implements StorageService {
	private final Path rootLocation = Paths.get("D:\\xampp\\htdocs\\images");

	@Override
	public MessageResponse store(MultipartFile file) {
		try {
			String currentfileName = file.getName() + "_" + System.currentTimeMillis()
					 +findExtension(file.getOriginalFilename());
			Files.copy(file.getInputStream(), this.rootLocation.resolve(currentfileName));
		return new MessageResponse(true, currentfileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MessageResponse(false, "Opération non efféctuée");

	}

	@Override
	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String findExtension(String fileName) {
		int lastIndex = fileName.lastIndexOf('.');
		if (lastIndex == -1) {
			return "";
		}
		return fileName.substring(lastIndex );
	}

}
