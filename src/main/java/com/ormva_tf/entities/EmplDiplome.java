package com.ormva_tf.entities;

import java.io.Serializable;
import java.time.Year;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class EmplDiplome implements Serializable{
	@Id
	KeyEmplDiplm id;
	private Year promotion;
	public EmplDiplome() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmplDiplome(KeyEmplDiplm id, Year promotion) {
		super();
		this.id = id;
		this.promotion = promotion;
	}
	public KeyEmplDiplm getId() {
		return id;
	}
	public void setId(KeyEmplDiplm id) {
		this.id = id;
	}
	public Year getPromotion() {
		return promotion;
	}
	public void setPromotion(Year promotion) {
		this.promotion = promotion;
	}
	
	

	
	
}
