package com.addinn.certification.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private boolean opened ;
	private Date date;
	private boolean certif ;
	
	@ManyToOne
	private Client client;
	@ManyToOne
	private Banker banker;
	@JsonIgnore
	@OneToMany(mappedBy = "request")
	 private List <CheckBook> checkbook;
	
	

}
