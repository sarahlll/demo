package com.formation.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.demo.entities.Adresse;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {

}
