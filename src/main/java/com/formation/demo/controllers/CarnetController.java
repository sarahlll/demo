package com.formation.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.formation.demo.entities.Carnet;
import com.formation.demo.services.CarnetService;



@RestController
public class CarnetController {

	@Autowired // instancier
	CarnetService carnetService;

	@RequestMapping("/carnets")
	public List<Carnet> getAllCarnet() {
		return carnetService.getAll();

	}

	
	
	// Ajout de carnet par formulaire en post
	@RequestMapping(value="/formulaire",method=RequestMethod.POST)
	public ModelAndView add(@Validated Carnet carnet, BindingResult bindingResult)  {   //avant  on avais @ModelAttribute //BindingResult pour afficher erreur
	
		if(bindingResult.hasErrors()) {
			return new ModelAndView ("pages/formulaire.html").addObject("carnet", carnet);
			
		}
		System.out.println(carnet);
		carnetService.addcarnet(carnet);
		return new ModelAndView ("pages/carnetAffichesultat.html").addObject("carnet", carnet); //carnetAffichesultat.html nous affiche nos entrées sans erreur de champs vide
	}
	
}