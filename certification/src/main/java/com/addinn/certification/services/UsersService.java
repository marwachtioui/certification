package com.addinn.certification.services;

import com.addinn.certification.entities.Users;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.model.PasswordDto;

public interface UsersService {

	public MessageResponse activate(Integer id);

	public MessageResponse changePassword(PasswordDto passwordDto);
}
