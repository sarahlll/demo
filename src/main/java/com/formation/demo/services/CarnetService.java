package com.formation.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.demo.entities.Carnet;
import com.formation.demo.repositories.CarnetRepository;

@Service
public class CarnetService {
 private final CarnetRepository carnetRepository;
	
 @Autowired
	CarnetService(CarnetRepository carnetRepository){
	 this.carnetRepository= carnetRepository;
 }

	public List<Carnet> getAll() {
		return carnetRepository.findAll();
	}
	public Optional<Carnet> findById(Long id) {
		return carnetRepository.findById(id);
	}

	// les add dans la BDD
	public void addcarnet(Carnet carnet) {
		carnetRepository.save(carnet);
	}

	public void AddById(Integer id) {
	}

	
	// les delete
	public void deletecarnet(Carnet carnet) {
		carnetRepository.delete(carnet);
	}

	public void deleteById( Long id) {
		carnetRepository.deleteById(id);
	}

	
}
