package com.formation.demo.carnet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Carnet {

	private int id;
	
	@NotNull
	private Civilite civilite;
	
	//@NotBlank              //@NotBlank verification de champs de formulaire
	@Pattern(regexp="(?i)[a-z]{2,50}", message="{com.formation.demo.constraint.nom.message}")//?i ignorer la case maj min//ou message="ERROR, ceci ne respecte pas les infos entrées")
	private String nom;
	
	//@NotBlank //(message= "vous n'avez pas rempli le champs nom") //message personnalisé
	@Pattern(regexp="(?i)[a-z\\- ] {2,100}", message="{com.formation.demo.constraint.prenom.message}")
	private String prenom;
	
	@NotBlank
	private String dateDeNaissance;
	
	//@NotBlank
	@Pattern(regexp="(\\+[0-9]|[0] {2})[0-9]{6,14}(?:x.+]?$)", message="{com.formation.demo.constraint.tel.message}")
	private String tel;
	
	//@NotBlank(message="{com.formation.demo.constraint.email.message}")//message special properties
	@Pattern(regexp="(\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b)", message="{com.formation.demo.constraint.email.message}")
	private String email;
	
	//@NotBlank
	@Pattern(regexp="[0-9]{5}", message="{com.formation.demo.constraint.cp.message}")
	private String cp;
	
	//@NotBlank
	@Pattern(regexp="(?i)[a-z -]{1,45}", message="{com.formation.demo.constraint.ville.message}")
	private String ville;
	
	
	//Constructeur Vide
	public Carnet() {
	
	}
	//Constructeur
	public Carnet(int id, Civilite civilite, String nom, String prenom, String dateDeNaissance, String tel,
			String email, String cp, String ville) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.tel = tel;
		this.email = email;
		this.cp = cp;
		this.ville = ville;
	}
	
	//Accesseurs
	public int getId() {
		return id;
	
	}
	public void setId(int id) {
		this.id = id;
	}
	public Civilite getCivilite() {
		return civilite;
	}
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	
}
