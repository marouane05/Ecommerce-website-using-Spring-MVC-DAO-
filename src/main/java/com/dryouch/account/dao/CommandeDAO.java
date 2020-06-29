package com.dryouch.account.dao;

import java.util.List;

import com.dryouch.account.model.Commande;

public interface CommandeDAO {
 public List <Commande> getPanier(String name);
	//public Commande getPanier(String name);
 public List<Commande> ticket (String name) ;
 public void ViderPanier(String name) ; 
}
