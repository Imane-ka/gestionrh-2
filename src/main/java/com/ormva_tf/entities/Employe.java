package com.ormva_tf.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employe implements Serializable {
	@Id
	private String cin;
	private String prenom;
	private String nom;
	private String email;
	private String sexe;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	private String adresse;
	private String photo;
	private int nbrEnfants;
	private String numFixe;
	private String numMobile;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateEntree;
	@ManyToOne
	private Entite entite;
	@OneToMany(mappedBy = "id.employe", fetch = FetchType.LAZY)
	private Collection<EmplFonction> emplFonction;
	@OneToMany(mappedBy = "id.employe", fetch = FetchType.LAZY)
	private Collection<EmplDiplome> emplDiplomes;
	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY)
	private Collection<Conge> conges;
	private String nationalite;
	private String matricule;
	private String rib;

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(String cin, String prenom, String nom, String email, String sexe, Date dateNaissance, String adresse,
			String photo, int nbrEnfants, String numFixe, String numMobile, Date dateEntree, Entite entite,
			Collection<EmplFonction> emplFonction, String nationalite, String salaireDeBase, String matricule,
			String rib) {
		super();
		this.cin = cin;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.photo = photo;
		this.nbrEnfants = nbrEnfants;
		this.numFixe = numFixe;
		this.numMobile = numMobile;
		this.dateEntree = dateEntree;
		this.entite = entite;
		this.emplFonction = emplFonction;
		this.nationalite = nationalite;
		this.matricule = matricule;
		this.rib = rib;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getNbrEnfants() {
		return nbrEnfants;
	}

	public void setNbrEnfants(int nbrEnfants) {
		this.nbrEnfants = nbrEnfants;
	}

	public String getNumFixe() {
		return numFixe;
	}

	public void setNumFixe(String numFixe) {
		this.numFixe = numFixe;
	}

	public String getNumMobile() {
		return numMobile;
	}

	public void setNumMobile(String numMobile) {
		this.numMobile = numMobile;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	public Collection<EmplFonction> getEmplFonction() {
		return emplFonction;
	}

	public void setEmplFonction(Collection<EmplFonction> emplFonction) {
		this.emplFonction = emplFonction;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

}
