package com.addinn.certification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addinn.certification.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
