package com.addinn.certification.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.services.StorageService;

@RestController
@RequestMapping("/upload")
@CrossOrigin("*")
public class UploadController {

	@Autowired
	private StorageService storageService;

	@PostMapping
	public MessageResponse upload(@RequestParam("file") MultipartFile file) {
		return storageService.store(file);
	}

	@GetMapping("/{filename:.+}")
	public Resource getFile(@PathVariable String filename) {
		Resource file = storageService.loadFile(filename);
		return file;
	}

}
