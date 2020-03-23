package com.addinn.certification.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addinn.certification.entities.Company;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.repositories.CompanyRepository;
import com.addinn.certification.services.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public MessageResponse save(Company company) {

		boolean exist = companyRepository.existsByNom(company.getNom());

		if (exist) {
			return new MessageResponse(false, "Nom de la banque existe");
		}
		exist = companyRepository.existsByEmail(company.getEmail());
		if (exist) {
			return new MessageResponse(false, "Email de la banque existe");
		}

		companyRepository.save(company);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(Company company) {

		boolean exist = companyRepository.existsByNomAndId(company.getNom(), company.getId());

		if (!exist) {
			exist = companyRepository.existsByNom(company.getNom());
			if (exist) {
				return new MessageResponse(false, "Nom de la banque existe");
			}
		}

		exist = companyRepository.existsByEmailAndId(company.getEmail(), company.getId());
		if (!exist) {
			exist = companyRepository.existsByEmail(company.getEmail());
			if (exist) {
				return new MessageResponse(false, "Email de la banque existe");
			}
		}

		companyRepository.save(company);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse delete(Integer id) {

		boolean exist = companyRepository.existsByIdAndAgenciesIsNotNull(id);
		if (exist) {
			return new MessageResponse(false, "Banque associée a une ou plusieurs agence");
		}

		companyRepository.deleteById(id);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Transactional(readOnly = true)
	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Company findById(Integer id) {
	
		return companyRepository.findById(id).orElse(null);
	}

}
