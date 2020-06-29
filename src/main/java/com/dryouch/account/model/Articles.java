package com.dryouch.account.model;
import javax.persistence.*;
@Entity
@Table(name = "articles")
public class Articles {
	
	private Long codearticle ;
	private String designation ;
	private int prix ;
	private String stock ;
	private String categorie ;
	private String image;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getCodearticle() {
		return codearticle;
	}
	public void setCodearticle(Long codearticle) {
		this.codearticle = codearticle;
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
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
