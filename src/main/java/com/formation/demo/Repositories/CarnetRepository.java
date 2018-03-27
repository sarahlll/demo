package com.formation.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.demo.Entities.Carnet;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet, Long > {
	

}
