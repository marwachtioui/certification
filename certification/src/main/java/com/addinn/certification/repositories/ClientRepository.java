package com.addinn.certification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addinn.certification.entities.Client;

public interface ClientRepository  extends JpaRepository<Client, Integer>{


	boolean existsByEmail(String email);

	boolean existsByEmailAndId(String email, Integer id);

}
