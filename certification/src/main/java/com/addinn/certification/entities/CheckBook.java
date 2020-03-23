package com.addinn.certification.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
@Data
@Entity
public class CheckBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numCheque ;
	private String nameReciever;
	private String nameIreceiver;
	private String amount ;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne
	private Request request ;
	
	
	
	
	

}
