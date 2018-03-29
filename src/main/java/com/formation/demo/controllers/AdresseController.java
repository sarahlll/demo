package com.formation.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.demo.entities.Adresse;
import com.formation.demo.entities.Carnet;
import com.formation.demo.entities.Civilite;
import com.formation.demo.services.AdresseService;

@RestController
public class AdresseController {
	@Autowired
	private  AdresseService adresseService;

	@GetMapping("/details")
	public List<Adresse> getAllAdresse()
	{   // new carnet avec constructeur
		Carnet carnet1= new Carnet(1L, Civilite.M, "POTTER", "James", "1999-10-18","0123458970", "jamespotter@yahoo.fr", "44015", "Londre"); //on force le 1 en Long
		 
		//new adresse avec des Set
		Adresse adresse1=new Adresse();
		adresse1.setId(1L);
		adresse1.setNumber(24);
		adresse1.setStreet("Private Drive");
		adresse1.setPostcode(44015);
		adresse1.setTown("Londres");
		
		
		List<Adresse> listadresses= new ArrayList<Adresse>();
		listadresses.add(adresse1);
		carnet1.setAdresses(listadresses);
		adresseService.addadresse(adresse1);
		
		
		return adresseService.getAll();
	}
	
	
	
	
	
	
}