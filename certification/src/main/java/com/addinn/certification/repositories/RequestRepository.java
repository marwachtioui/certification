package com.addinn.certification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addinn.certification.entities.Request;

public interface RequestRepository  extends JpaRepository<Request, Integer>{

}
