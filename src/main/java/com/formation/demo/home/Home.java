package com.formation.demo.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@ Controller
public class Home {
	@GetMapping("/")  // root:(url ici racine)
		@ResponseBody // renvoi d'information: je te renvoi pas le chemin de l'html mais le corps de page!
	public String index() {
		return "<h1>Hello!<h1>";
	}
	
	
	@GetMapping("/test")
	public String index2(@RequestParam(required=false, defaultValue="defaut") String name, Model model) {
		model.addAttribute("key",name);
		return "index";
	}
	
}
