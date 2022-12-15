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
public class Entite implements Serializable{
	@Id
	@GeneratedValue
	private Long id ;
	private String nom ;
	@ManyToOne
	private Type type ;
	@ManyToOne
	private Entite entitePere ;
	@OneToMany(mappedBy = "entitePere" , fetch = FetchType.LAZY)
	private Collection<Entite> entiteFils ;
	@OneToMany(mappedBy = "entite" , fetch = FetchType.LAZY)
	private Collection<Employe> employes ;
	public Entite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Entite(String nom, Type type, Entite entitePere, Collection<Entite> entiteFils,
			Collection<Employe> employes) {
		super();
		this.nom = nom;
		this.type = type;
		this.entitePere = entitePere;
		this.entiteFils = entiteFils;
		this.employes = employes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Entite getEntitePere() {
		return entitePere;
	}
	public void setEntitePere(Entite entitePere) {
		this.entitePere = entitePere;
	}
	public Collection<Entite> getEntiteFils() {
		return entiteFils;
	}
	public void setEntiteFils(Collection<Entite> entiteFils) {
		this.entiteFils = entiteFils;
	}
	public Collection<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
	
	
}
