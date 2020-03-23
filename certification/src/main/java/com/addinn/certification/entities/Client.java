package com.addinn.certification.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class Client  extends Users{
	@ManyToOne
	private Agency agency;
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Request> request ;
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List <Account> account ;
	
	

}
