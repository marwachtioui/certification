package com.addinn.certification.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String accountNumber ;
	private boolean suspended ;
	private Date date ;
	private double solde;
	@ManyToOne
	private Banker banker;
	@ManyToOne
	private Client client;
	
	
}
