package com.addinn.certification.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class Banker extends Users {
	@JsonIgnore
	@OneToMany(mappedBy = "banker")
	private List<Request> request ;
	@JsonIgnore
	@OneToMany(mappedBy = "banker")
	private List<Account> account ;
	
	@ManyToOne
	private Agency agency;
	
	
	
}
