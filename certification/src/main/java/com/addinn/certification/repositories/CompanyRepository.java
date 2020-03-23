package com.addinn.certification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addinn.certification.entities.Company;

public interface CompanyRepository  extends JpaRepository<Company, Integer>{

	boolean existsByNom(String nom);

	boolean existsByEmail(String email);

	boolean existsByNomAndId(String nom, Integer id);

	boolean existsByEmailAndId(String email, Integer id);

	boolean existsByIdAndAgenciesIsNotNull(Integer id);
}
