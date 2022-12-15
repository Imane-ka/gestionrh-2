package com.ormva_tf.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class TypeConge implements Serializable{
	@Id
	@GeneratedValue
	private int id ;
	private String nom ;
	@OneToMany(mappedBy = "typeConge" , fetch =FetchType.LAZY)
	private Collection<Conge> conges ;
	public TypeConge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeConge(String nom, Collection<Conge> conges) {
		super();
		this.nom = nom;
		this.conges = conges;
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
	public Collection<Conge> getConges() {
		return conges;
	}
	public void setConges(Collection<Conge> conges) {
		this.conges = conges;
	}
	
}
