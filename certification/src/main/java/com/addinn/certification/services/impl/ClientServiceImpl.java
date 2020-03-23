package com.addinn.certification.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.addinn.certification.entities.Client;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.repositories.ClientRepository;
import com.addinn.certification.repositories.UsersRepository;
import com.addinn.certification.services.ClientService;
import com.addinn.certification.util.EmailUtil;
import com.addinn.certification.util.PasswordGeneratorUtil;

@Service
@Transactional

public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private EmailUtil emailUtil;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private PasswordGeneratorUtil passwordGeneratorUtil;
	 @Override
	public MessageResponse save(Client client) {

		boolean exist = userRepository.existsByEmail(client.getEmail());

		if (exist) {
			return new MessageResponse(false, "Email du banqier déjà existe");
		}
		client.setEnabled(true);

		String password = passwordGeneratorUtil.generate();

		String cryptedPassword = passwordEncoder.encode(password);
		client.setPassword(cryptedPassword);

		clientRepository.save(client);
		String subject = "Compte";

		String body = "Bonjour " + client.getNom() + " " + client.getPrenom()
				+ ", \n Vous trouvez votre login et mot de passe \n" + "Email : " + client.getEmail()
				+ "\n Mot de passe : " + password;
		emailUtil.sendEmail(client.getEmail(), subject, body);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}
	 
	 @Override
		public MessageResponse update(Client client) {

			boolean exist = clientRepository.existsByEmailAndId(client.getEmail(), client.getId());
			if (!exist) {

				exist = clientRepository.existsByEmail(client.getEmail());
				if (exist) {

					return new MessageResponse(false, "Email de ce client existe");
				}
			}

			clientRepository.save(client);
			return new MessageResponse(true, "Opération effectuée avec succès");

		}
	 

		@Transactional(readOnly = true)
		@Override
		public List<Client> findAll() {

			return clientRepository.findAll();
		}
		
		@Override
		public Client findById(Integer id) {
			
			return clientRepository.findById(id).orElse(null);
		} 
	 
}
