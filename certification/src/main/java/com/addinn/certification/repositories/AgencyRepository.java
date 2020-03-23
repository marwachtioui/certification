package com.addinn.certification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addinn.certification.entities.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Integer> {

	boolean existsByNomAndId(String nom, Integer id);

	boolean existsByEmailAndId(String email, Integer id);

	boolean existsByEmail(String email);

	boolean existsByNom(String nom);

	boolean existsByIdAndBankersIsNotNull(Integer id);

	
}
