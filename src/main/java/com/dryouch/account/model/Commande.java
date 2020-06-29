package com.dryouch.account.model;

import java.util.Date;


public class Commande {

	private int id ; 
	private int numcommande ;
	private String codeclient ;
	private String designation ; 
	private int prix ; 
	private Date datecommande ;
	private int number ; 
	
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumcommande() {
		return numcommande;
	}
	public void setNumcommande(int numcommande) {
		this.numcommande = numcommande;
	}
	public String getCodeclient() {
		return codeclient;
	}
	public void setCodeclient(String codeclient) {
		this.codeclient = codeclient;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public Date getDatecommande() {
		return datecommande;
	}
	public void setDatecommande(Date datecommande) {
		this.datecommande = datecommande;
	} 
	
	
}
