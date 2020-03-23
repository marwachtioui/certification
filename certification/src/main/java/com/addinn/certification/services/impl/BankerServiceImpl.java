package com.addinn.certification.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addinn.certification.entities.Banker;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.repositories.BankerRepository;
import com.addinn.certification.repositories.UsersRepository;
import com.addinn.certification.services.BankerService;
import com.addinn.certification.util.EmailUtil;
import com.addinn.certification.util.PasswordGeneratorUtil;

@Service
@Transactional

public class BankerServiceImpl implements BankerService {

	@Autowired
	private BankerRepository bankerRepository;
	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private EmailUtil emailUtil;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private PasswordGeneratorUtil passwordGeneratorUtil;

	@Override
	public MessageResponse save(Banker banker) {

		boolean exist = userRepository.existsByEmail(banker.getEmail());

		if (exist) {
			return new MessageResponse(false, "Email du banqier déjà existe");
		}
		banker.setEnabled(true);

		String password = passwordGeneratorUtil.generate();

		String cryptedPassword = passwordEncoder.encode(password);
		banker.setPassword(cryptedPassword);

		bankerRepository.save(banker);
		String subject = "Compte";

		String body = "Bonjour " + banker.getNom() + " " + banker.getPrenom()
				+ ", \n Vous trouvez votre login et mot de passe \n" + "Email : " + banker.getEmail()
				+ "\n Mot de passe : " + password;
		emailUtil.sendEmail(banker.getEmail(), subject, body);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(Banker banker) {

		boolean exist = bankerRepository.existsByEmailAndId(banker.getEmail(), banker.getId());
		if (!exist) {

			exist = bankerRepository.existsByEmail(banker.getEmail());
			if (exist) {

				return new MessageResponse(false, "Email de ce banquier existe");
			}
		}

		bankerRepository.save(banker);
		return new MessageResponse(true, "Opération effectuée avec succès");

	}

	@Transactional(readOnly = true)
	@Override
	public List<Banker> findAll() {

		return bankerRepository.findAll();
	}

	@Override
	public Banker findById(Integer id) {
		// TODO Auto-generated method stub
		return bankerRepository.findById(id).orElse(null);
	}

}
