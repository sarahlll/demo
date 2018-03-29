package com.formation.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.demo.entities.Carnet;
import com.formation.demo.entities.Civilite;
import com.formation.demo.entities.Compte;
import com.formation.demo.services.CarnetService;
import com.formation.demo.services.CompteService;

@RestController
public class CompteController {
	private final CompteService compteService;
	private final CarnetService carnetService;
	
@Autowired
	public CompteController(CompteService compteService, CarnetService carnetService) {
		super();
		this.compteService = compteService;
		this.carnetService = carnetService;
	}


	@GetMapping("/details")
	public List<Compte> getAllComptes() {

		Carnet carnet1 = new Carnet(1L, Civilite.M, "POTTER", "James", "1999-10-18", "0123458970",
				"jamespotter@yahoo.fr", "44015", "Londres");
		{
			
			Compte compte1 = new Compte();
			compte1.setNom("POTTER");
			compte1.setNumber(1234567890);
			
			

			/*List<Compte> listecompte = new ArrayList<Compte>();
			listecompte.add(compte1);
			carnet1.setComptes(listecompte);
			compteService.addcompte(compte1);*/
			
			
			compte1.setCarnet(carnet1);                            //(carnetService.findById(2L).get();
			carnetService.addcarnet(carnet1);
			
			compteService.addcompte(compte1);

			return compteService.getAll();
		}
	}
}
