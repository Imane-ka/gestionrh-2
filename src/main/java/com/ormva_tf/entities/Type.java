package com.ormva_tf.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Type implements Serializable {
	@Id
	@GeneratedValue
	private int id ;
	private String nom ;
	@OneToMany(mappedBy = "type" , fetch = FetchType.LAZY)
	private Collection<Entite> entites ;
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type(String nom, Collection<Entite> entites) {
		super();
		this.nom = nom;
		this.entites = entites;
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
	public Collection<Entite> getEntites() {
		return entites;
	}
	public void setEntites(Collection<Entite> entites) {
		this.entites = entites;
	}
	
	
}
