package com.addinn.certification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addinn.certification.entities.CheckBook;

public interface CheckBookRepository  extends JpaRepository<CheckBook, Integer>{

	boolean existsByNumCheque(Integer numCheque);

}
