package com.addinn.certification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addinn.certification.entities.Banker;

public interface BankerRepository  extends JpaRepository<Banker, Integer> {

	boolean existsByNom(String nom);

	boolean existsByEmailAndId(String email, Integer id);

	boolean existsByEmail(String email);


	

}
