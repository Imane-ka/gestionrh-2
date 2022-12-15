package com.ormva_tf.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Diplome implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	@ManyToOne
	private Filiere filiere;
	@OneToMany(mappedBy = "id.diplome", fetch = FetchType.LAZY)
	private Collection<EmplDiplome> emplDiplomes;

	public Diplome() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diplome(String nom, Filiere filiere, Collection<EmplDiplome> emplDiplomes) {
		super();
		this.nom = nom;
		this.filiere = filiere;
		this.emplDiplomes = emplDiplomes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Collection<EmplDiplome> getEmplDiplomes() {
		return emplDiplomes;
	}

	public void setEmplDiplomes(Collection<EmplDiplome> emplDiplomes) {
		this.emplDiplomes = emplDiplomes;
	}

}
