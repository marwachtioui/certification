package com.addinn.certification.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addinn.certification.entities.Client;
import com.addinn.certification.entities.Request;

public interface RequestRepository  extends JpaRepository<Request, Integer>{

	List<Request> findByClient(Client clt);

}
