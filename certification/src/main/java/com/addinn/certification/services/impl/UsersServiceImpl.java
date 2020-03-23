package com.addinn.certification.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.addinn.certification.entities.Users;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.model.PasswordDto;
import com.addinn.certification.repositories.UsersRepository;
import com.addinn.certification.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public MessageResponse activate(Integer id) {
		Users user = usersRepository.findById(id).orElse(null);
		if (user == null) {
			return new MessageResponse(false, "Utilisateur n'existe pas");
		}

		user.setEnabled(!user.isEnabled());
		usersRepository.save(user);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse changePassword(PasswordDto passwordDto) {
		Users user = usersRepository.findById(passwordDto.getId()).orElse(null);
		if (user == null) {
			return new MessageResponse(false, "Utilisateur n'existe pas");
		}

		boolean valid = passwordEncoder.matches(passwordDto.getOldPassword(), user.getPassword());
		if (!valid) {
			return new MessageResponse(false, "Ancien mot de passe incorrect");
		}

		String cryptedPassword = passwordEncoder.encode(passwordDto.getNewPassword());
		user.setPassword(cryptedPassword);
		usersRepository.save(user);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

}
