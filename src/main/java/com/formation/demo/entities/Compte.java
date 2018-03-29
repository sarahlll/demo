package com.formation.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Compte {

	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)	
	private Long id;
	
	private Integer number;
	
	private String nom;

	@ManyToOne(fetch=FetchType.EAGER) // la relation est chargée par défaut
	@JoinColumn(name="carnet")
	private Carnet carnet;           //declarer ma variable carnet
	
	public Carnet getCarnet() {
		return carnet;
	}

	public void setCarnet(Carnet carnet) {
		this.carnet = carnet;
	}


	private List<Carnet> carnets;
	
	
	


	public Compte(Long id, Integer number, String nom) {
		super();
		this.id = id;
		this.number = number;
		this.nom = nom;
	}

	public Compte() {
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
