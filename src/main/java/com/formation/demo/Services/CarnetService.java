package com.formation.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.demo.Entities.Carnet;
import com.formation.demo.Repositories.CarnetRepository;

@Service
public class CarnetService {
@Autowired
private CarnetRepository cr;

public List<Carnet> GetAll() {
	return cr.findAll();
	
}

}
