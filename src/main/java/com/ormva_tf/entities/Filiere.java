 package com.ormva_tf.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Filiere implements Serializable{
	@Id
	@GeneratedValue
	private int id ;
	private String nom ;
	@OneToMany(mappedBy = "filiere", fetch = FetchType.LAZY)
	private Collection<Diplome> diplomes ;
	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Filiere(String nom, Collection<Diplome> diplomes) {
		super();
		this.nom = nom;
		this.diplomes = diplomes;
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
	public Collection<Diplome> getDiplomes() {
		return diplomes;
	}
	public void setDiplomes(Collection<Diplome> diplomes) {
		this.diplomes = diplomes;
	}
	
}
