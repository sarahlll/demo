package com.formation.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.demo.entities.Carnet;
import com.formation.demo.repositories.CarnetRepository;

@Service
public class CarnetService {
	
	@Autowired
	CarnetRepository carnetRepository;

	public List<Carnet> getAll() {
		return carnetRepository.findAll();

	}
	
	//pour add dans la BDD
public void addcarnet(Carnet carnet) {
	carnetRepository.save(carnet);
}
}
