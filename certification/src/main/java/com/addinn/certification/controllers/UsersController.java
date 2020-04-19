package com.addinn.certification.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addinn.certification.entities.Users;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.model.PasswordDto;
import com.addinn.certification.services.UsersService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UsersController {
	@Autowired
	private UsersService usersService;

	@PatchMapping("/{id}")
	public MessageResponse activate(@PathVariable Integer id) {
		return usersService.activate(id);
	}

	@PatchMapping
	public MessageResponse changePassword(@RequestBody PasswordDto passwordDto) {
		return usersService.changePassword(passwordDto);
	}
	
	@GetMapping("/{email}")
	public Users findByEmail(@PathVariable String email) {
		return (Users) usersService.loadUserByUsername(email);
	}
}
