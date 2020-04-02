package com.addinn.certification.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity

public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String nom;
	private String email;
	private String adresse;
	private String tel ;
	private String fax ;
	@JsonIgnore
	 @OneToMany(mappedBy = "company")
	 private List<Agency> agencies;
	
}
