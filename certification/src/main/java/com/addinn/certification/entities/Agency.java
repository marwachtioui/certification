package com.addinn.certification.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class Agency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String adresse;
	private String email;
	private String tel ;
	private String fax;
	@JsonIgnore
	@OneToMany(mappedBy = "agency")
	private List<Client> clients;
	@JsonIgnore
	@OneToMany(mappedBy = "agency")
	private List<Banker> bankers;
	@ManyToOne
	private Company company;
	

}
