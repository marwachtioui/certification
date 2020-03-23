package com.addinn.certification.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.addinn.certification.entities.Agency;
import com.addinn.certification.model.MessageResponse;
import com.addinn.certification.repositories.AgencyRepository;
import com.addinn.certification.services.AgencyService;



@Service
@Transactional
public class AgencyServiceImpl implements AgencyService{
	
	@Autowired
	private AgencyRepository agencyRepository ;
	
	@Override
	public MessageResponse save(Agency agency) {
		
		boolean exist = agencyRepository.existsByNom(agency.getNom());
		
		if (exist) {
			
			return new MessageResponse(false, "Nom de l'agence existe");
			
		}
		exist = agencyRepository.existsByEmail(agency.getEmail());
		if (exist) {
			return new MessageResponse(false, "Email de l'agence existe");
		}

             agencyRepository.save(agency);
 

		return new MessageResponse(true, "Opération effectuée avec succès");
	}
	
	@Override
	
	public MessageResponse update(Agency agency) {
		
		boolean exist = agencyRepository.existsByNomAndId(agency.getNom(), agency.getId());
		
		if (!exist) {
			
			exist = agencyRepository.existsByNom(agency.getNom());
			
			if (exist) {
				
				return new MessageResponse(false, "Nom de l'agence existe");
			}
		}
		
		exist = agencyRepository.existsByEmailAndId(agency.getEmail(), agency.getId());
		
		if (!exist) {
			
			exist = agencyRepository.existsByEmail(agency.getEmail());
			if (exist) {
				return new MessageResponse(false, "Email de l'agence existe");
			}
		}
		
		agencyRepository.save(agency);
		return new MessageResponse(true, "Opération effectuée avec succès");
		
		
	}
	
	@Override
	
	public MessageResponse delete(Integer id) {
		
		boolean exist = agencyRepository.existsByIdAndBankersIsNotNull(id);
		if (exist) {
			return new MessageResponse(false, "cet agence est lié à une banque");
			
		}
		agencyRepository.deleteById(id);
		return new MessageResponse(true, "Opération effectuée avec succès");
		
	}
	  
	
	@Transactional(readOnly = true)
	@Override
	public List<Agency> findAll() {
		
		return agencyRepository.findAll();
	
	}
	
	@Transactional(readOnly=true)
	@Override
	public Agency findById(Integer id) {
		// TODO Auto-generated method stub
		return agencyRepository.findById(id).orElse(null);
		
	}

}
