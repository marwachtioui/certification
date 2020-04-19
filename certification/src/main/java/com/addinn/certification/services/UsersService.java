package com.addinn.certification.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.addinn.certification.entities.Users;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.model.PasswordDto;

public interface UsersService extends UserDetailsService {

	public MessageResponse activate(Integer id);

	public MessageResponse changePassword(PasswordDto passwordDto);
}
