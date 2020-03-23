package com.addinn.certification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.addinn.certification.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	boolean existsByNom(String nom);

	boolean existsByEmail(String email);

	boolean existsByNomAndId(String nom, Integer id);

	//boolean existsByIdAndBankersIsNotNull(Integer id);

}
