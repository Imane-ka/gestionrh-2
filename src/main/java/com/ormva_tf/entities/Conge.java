package com.ormva_tf.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Conge implements Serializable{
	@Id
	@GeneratedValue
	 private long id ;
	@Column( columnDefinition = "varchar(32) default 'Attente'")
	 private String status;
	 private int nbr_jour ;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date dateDemande ;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date dateDebut ;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date dateFin ;
	 @ManyToOne
	 private TypeConge typeConge ;
	 @ManyToOne
	 private Employe employe ;
	public Conge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Conge(String status, int nbr_jour, Date dateDemande, Date dateDebut, Date dateFin, TypeConge typeConge,
			Employe employe) {
		super();
		this.status = status;
		this.nbr_jour = nbr_jour;
		this.dateDemande = dateDemande;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.typeConge = typeConge;
		this.employe = employe;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNbr_jour() {
		return nbr_jour;
	}
	public void setNbr_jour(int nbr_jour) {
		this.nbr_jour = nbr_jour;
	}
	public Date getDateDemande() {
		return dateDemande;
	}
	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public TypeConge getTypeConge() {
		return typeConge;
	}
	public void setTypeConge(TypeConge typeConge) {
		this.typeConge = typeConge;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	 


}
