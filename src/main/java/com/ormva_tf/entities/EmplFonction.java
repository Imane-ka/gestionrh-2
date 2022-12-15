package com.ormva_tf.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class EmplFonction implements Serializable {
	@Id
	KeyEmplFonct id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDebutFonction;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFinFonction;

	public EmplFonction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmplFonction(KeyEmplFonct id, Date dateDebutFonction, Date dateFinFonction) {
		super();
		this.id = id;
		this.dateDebutFonction = dateDebutFonction;
		this.dateFinFonction = dateFinFonction;

	}

	public KeyEmplFonct getId() {
		return id;
	}

	public void setId(KeyEmplFonct id) {
		this.id = id;
	}

	public Date getDateDebutFonction() {
		return dateDebutFonction;
	}

	public void setDateDebutFonction(Date dateDebutFonction) {
		this.dateDebutFonction = dateDebutFonction;
	}

	public Date getDateFinFonction() {
		return dateFinFonction;
	}

	public void setDateFinFonction(Date dateFinFonction) {
		this.dateFinFonction = dateFinFonction;
	}

	public Employe getEmploye() {
		return getId().getEmploye();
	}

	public void setEmploye(Employe employe) {
		getId().setEmploye(employe);
	}

	public Fonction getFonction() {
		return getId().getFonction();
	}

	public void setFonction(Fonction fonction) {
		getId().setFonction(fonction);
	}

}
