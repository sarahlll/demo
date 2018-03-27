package com.formation.demo.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.formation.demo.Entities.Carnet;
import com.formation.demo.Services.CarnetService;
import com.formation.demo.carnet.Civilite;

@RestController
public class CarnetController {
	@Autowired // instentiation
	private CarnetService cs;

	List<Carnet> listeCarnets= 
			new ArrayList<Carnet>(Arrays.asList( new Carnet(1, Civilite.M, "Besson", "Luc", "1959-13-18", "0000000000", "5 avenue de l'Element", "75015", "Paris"),
			
			new Carnet(2, Civilite.MME, "Austen", "Jane", "1738-12-16","0101010101", "1-16-5", "22", "Tokyo"),
			
			new Carnet(3, Civilite.M, "Potter", "Harry", "1989-01-20","0202020202", "24 private Drive", "44001", "Londres")));
	
	// mon premier commentaire du 26.03.18
	@GetMapping( "/carnets")
	public List<Carnet> getAllRest() {
		return this.listeCarnets;
		}
	@GetMapping("/carnetshtml")
	public ModelAndView getAll () {//Model model
		//model.addAttribute("liste", listeCarnets);
		ModelAndView mav= new ModelAndView("pages/carnets");
		mav.addObject("liste",listeCarnets)	;  // ici on passe dans liste la listeCarnets
		return mav;
	}
	
	@RequestMapping(value="/carnets/{id}", method=RequestMethod.GET)
	public Carnet getById(@PathVariable Integer id) {
    	for (Carnet c : this.listeCarnets) {
    		if (((Integer)c.getId()).equals(id)){
    			return c;
    		}
    	}
    	return null;
	}
	@RequestMapping(value="/carnets/{id}", method=RequestMethod.DELETE)
	public void DelById(@PathVariable Integer id) {
		 this.listeCarnets.removeIf(p -> ((Integer)p.getId()).equals(id)); // methode lambda
		//ou avec iterator
		 /*Iterator<Carnet> it= listeCarnets.iterator();
		while(it.hasNext()) {
			Carnet carnet= it.next();
			if(((Integer)carnet.getId()).equals(id))
			{
				it.remove();
			}
			
		}*/
		
	}
	
	
	//partie wafa(manquée le vendredi
	
	//@RequestMapping(value="/carnets") en brut
	@PostMapping("/carnets") //ajout JSON avec @RequestBody
	public void addjson(@RequestBody Carnet carnet)
	{
		this.listeCarnets.add(carnet);
	}
	// Ajout de carnet par formulaire en post
	@RequestMapping(value="/formulaire",method=RequestMethod.POST)
	public ModelAndView add(@Validated Carnet carnet, BindingResult bindingResult)  {   //avant  on avais @ModelAttribute //BindingResult pour afficher erreur
	
		if(bindingResult.hasErrors()) {
			return new ModelAndView ("pages/formulaire.html").addObject("carnet", carnet);
			//tant que erreur existe afficher formulaire
			//pas de else car il ici retourne quelque chose et il sort 
		}
		System.out.println(carnet);
		carnet.setId(listeCarnets.size()+1);
		this.listeCarnets.add(carnet);
		return new ModelAndView ("pages/carnetAffichesultat.html").addObject("carnet", carnet); //carnetAffichesultat.html nous affiche nos entrées sans erreur de champs vide
	}
	
	//pour l'affichage du OldFormulaire
	// recup formulaire créé
	/*@GetMapping(value="/formulaire")
	public ModelAndView form()
	{
		ModelAndView mav = new ModelAndView("pages/formulaire");		
		return mav;
	}*/
	
	
	
	// pour l'affichage du formulaire
		@GetMapping(value="/formulaire")
		public ModelAndView form()
		{
			ModelAndView mav = new ModelAndView("pages/formulaire");
			mav.addObject("carnet", new Carnet());
			return mav;
		}
	}
