package com.addinn.certification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addinn.certification.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
