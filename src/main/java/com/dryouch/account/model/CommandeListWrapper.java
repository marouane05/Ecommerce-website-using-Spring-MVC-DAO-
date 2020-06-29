package com.dryouch.account.model;

import java.util.ArrayList;

public class CommandeListWrapper {

	public ArrayList<Commande> commandes ;
	public ArrayList<Commande> getCommande(){
		
		return commandes ;
	}
	
	public void setCommande(ArrayList<Commande> commandes) {
		this.commandes = commandes ; 
	}
	
	
}
