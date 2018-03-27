package com.formation.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.demo.entities.Carnet;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet, Long> {
	//JPA
}