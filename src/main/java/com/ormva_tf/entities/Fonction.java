package com.ormva_tf.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Fonction implements Serializable{
	@Id
	@GeneratedValue
	private int id ;
	private String nom;
	@OneToMany(mappedBy = "id.fonction" , fetch = FetchType.LAZY)
	private Collection<EmplFonction> emplFonction ;
	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fonction(String nom, Collection<EmplFonction> emplFonction) {
		super();
		this.nom = nom;
		this.emplFonction = emplFonction;
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
	public Collection<EmplFonction> getEmplFonction() {
		return emplFonction;
	}
	public void setEmplFonction(Collection<EmplFonction> emplFonction) {
		this.emplFonction = emplFonction;
	}
	
}
