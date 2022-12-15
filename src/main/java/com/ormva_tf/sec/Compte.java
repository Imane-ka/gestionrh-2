package com.ormva_tf.sec;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Compte implements Serializable{
	@Id
   private String cin ;
	private String password ;
	@ManyToMany()
	@JoinTable(name = "roles_compte" , joinColumns = @JoinColumn(name = "cin" ), inverseJoinColumns = @JoinColumn(name = "role"))
	private Collection<Role> roles ;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String cin, String password, Collection<Role> roles) {
		super();
		this.cin = cin;
		this.password = password;
		this.roles = roles;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
   
}
