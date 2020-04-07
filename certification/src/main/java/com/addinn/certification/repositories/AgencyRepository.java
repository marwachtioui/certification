package com.addinn.certification.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addinn.certification.entities.Agency;
import com.addinn.certification.entities.Company;

public interface AgencyRepository extends JpaRepository<Agency, Integer> {

	boolean existsByNomAndId(String nom, Integer id);

	boolean existsByEmailAndId(String email, Integer id);

	boolean existsByEmail(String email);

	boolean existsByNom(String nom);

	boolean existsByIdAndBankersIsNotNull(Integer id);

	List<Agency> findByCompany(Company company);

	
}
