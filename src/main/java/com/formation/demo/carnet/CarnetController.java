package com.formation.demo.carnet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CarnetController {

	List<Carnet> listeCarnets= 
			new ArrayList<Carnet>(Arrays.asList( new Carnet(1, Civilite.M, "Besson", "Luc", "1959-13-18", "0000000000", "5 avenue de l'Element", "75015", "Paris"),
			
			new Carnet(2, Civilite.MME, "Austen", "Jane", "1738-12-16","0101010101", "1-16-5", "22", "Tokyo"),
			
			new Carnet(3, Civilite.M, "Potter", "Harry", "1989-01-20","0202020202", "24 private Drive", "44001", "Londres")));
	
	@GetMapping( "/carnets")
	public List<Carnet> getAllRest() {
		return this.listeCarnets;
		}
	@GetMapping("/carnetshtml")
	public ModelAndView getAll () {//Model model
		//model.addAttribute("liste", listeCarnets);
		ModelAndView mav= new ModelAndView("pages/carnets");
		mav.addObject(listeCarnets)	;
		return mav;
	}
	}
