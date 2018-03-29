package com.formation.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
//@Table(name="adresse")
public class Adresse {

	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)	
	private Long id;
	
	private Integer number;
	
	private String street;
	
	@Column(length=6)
	private Integer postcode;
	
	private String town;
	
	@ManyToMany(mappedBy="adresses") //on choisi entre carnets et adresse le principal
	
	private List<Carnet> carnets;

	public Adresse(Long id, Integer number, String street, Integer postcode, String town, List<Carnet> carnets) {
		super();
		carnets =new ArrayList<Carnet>(); //initialisation
		this.id = id;
		this.number = number;
		this.street = street;
		this.postcode = postcode;
		this.town = town;
		this.carnets = carnets;
	}

	public Adresse() {
		
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public List<Carnet> getCarnets() {
		return carnets;
	}

	public void setCarnets(List<Carnet> carnets) {
		this.carnets = carnets;
	}
	

	
	
	
}
