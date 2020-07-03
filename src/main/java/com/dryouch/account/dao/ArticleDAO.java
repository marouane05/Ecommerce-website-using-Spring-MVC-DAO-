package com.dryouch.account.dao;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.web.multipart.MultipartFile;

import com.dryouch.account.model.*;



public interface ArticleDAO {
	public List <Articles> getArticles();
	 public Articles DetailCatalogue(Long ref);
	 public void Commander(Long ref,String name, int prix);
	 public void ValiderCommande(int id);
	 public List <Articles> getArticlesByCategory(String cat) ; 
	 public void SupprimerProduit(String ref);
	 public void AjoutArticle(Articles article,byte[] image) throws SerialException, SQLException;
	 
	

}
