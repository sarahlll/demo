package com.formation.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.formation.demo.entities.Carnet;
import com.formation.demo.services.CarnetService;

@RestController
public class CarnetController {
	@Autowired//instantiation d'un singleton
	private  CarnetService carnetService;
	@GetMapping("/carnets")
	public List<Carnet> getAllCarnet()
	{   
		return carnetService.getAll();
	}
	@RequestMapping(value="/carnetshtml", method=RequestMethod.GET) 
	public ModelAndView getAll() { 
	ModelAndView mav = new ModelAndView("pages/carnets"); 
	mav.addObject("carnets", this.getAllCarnet()); 
	return mav; 
	}
	// carnetById
	@RequestMapping(value="/carnet/{id}", method=RequestMethod.GET) 
	public ModelAndView getById(@PathVariable Long id) { 
	ModelAndView mav = new ModelAndView("pages/carnet"); 
	mav.addObject("carnet", carnetService.findById(id).get()); 
	return mav; 
	}
	
	@GetMapping(value = "/formulaire")
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("pages/formulaire");
		mav.addObject("carnet", new Carnet());
		return mav;
	}
	@RequestMapping(value = "/formulaire", method = RequestMethod.POST)	
	public ModelAndView add(@Validated Carnet carnet, BindingResult br) {
		if (br.hasErrors()) {
			return new ModelAndView("pages/formulaire.html").addObject("carnet", carnet);
		}
		carnetService.addcarnet(carnet);
		return new ModelAndView("pages/carnets.html").addObject("carnet", carnet);
	}
	
	
	 //les delete
	@RequestMapping(value="/formulaire/{id}", method=RequestMethod.DELETE)
	public void DelById(@PathVariable Long id) {
		  carnetService.deleteById(id);
		}
	
	@RequestMapping(value="/formulaire", method=RequestMethod.DELETE)
	public void Delete(Carnet carnet) {
		  carnetService.deletecarnet(carnet);
		}
	
	
	//update (=un add en PUT)
	@RequestMapping(value="/formulaire", method=RequestMethod.PUT) 
	public ModelAndView update(@RequestBody Carnet carnet, BindingResult br) { 
		if (br.hasErrors()) {
			return new ModelAndView("pages/formulaire.html").addObject("carnet", carnet);
		}
		carnetService.addcarnet(carnet);
		return new ModelAndView("pages/carnets.html").addObject("carnet", carnet);
	}
	} 
