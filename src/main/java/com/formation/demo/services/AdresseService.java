package com.formation.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.demo.entities.Adresse;
import com.formation.demo.repositories.AdresseRepository;

public class AdresseService {

	@Autowired
	AdresseRepository ar;
	
	public List<Adresse> getAll() {
		return ar.findAll();
	}
	public Optional<Adresse> findById(Long id) {
		return ar.findById(id);
	}

	// les add dans la BDD
	public void addadresse(Adresse adresse) {
		ar.save(adresse);
	}

	public void AddById(Long id) {
	}

	
	// les delete
	public void deleteadresse(Adresse adresse) {
		ar.delete(adresse);
	}

	public void deleteById( Long id) {
		ar.deleteById(id);
	}

	
}

