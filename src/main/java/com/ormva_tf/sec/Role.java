package com.ormva_tf.sec;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Role implements Serializable{
	@Id
	private String role;
	@ManyToMany(mappedBy = "roles")
	private Collection<Compte> comptes ;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String role, Collection<Compte> comptes) {
		super();
		this.role = role;
		this.comptes = comptes;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
}
