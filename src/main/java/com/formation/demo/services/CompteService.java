package com.formation.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.demo.entities.Compte;

import com.formation.demo.repositories.CompteRepository;

public class CompteService {
	
	@Autowired
	CompteRepository cr;

	public List<Compte> getAll() {
		return cr.findAll();
	}

	public Optional<Compte> findById(Long id) {
		return cr.findById(id);
	}

	// les add dans la BDD
	public void addcompte(Compte compte) {
		cr.save(compte);
	}

	public void AddById(Long id) {
	}

	// les delete
	public void deletecompte(Compte compte) {
		cr.delete(compte);
	}

	public void deleteById(Long id) {
		cr.deleteById(id);
	}

}
