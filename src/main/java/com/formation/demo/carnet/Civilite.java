package com.formation.demo.carnet;

public enum Civilite {
	
	M("Monsieur"),MME("Madame");
	private String nom;
	

	private Civilite(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
