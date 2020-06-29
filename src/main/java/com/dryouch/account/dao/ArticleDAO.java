package com.dryouch.account.dao;
import java.util.List;

import com.dryouch.account.model.*;



public interface ArticleDAO {
	public List <Articles> getArticles();
	 public Articles DetailCatalogue(Long ref);
	 public void Commander(Long ref,String name, int prix);
	 public void ValiderCommande(int id);
	 
	

}
