package com.dryouch.account.dao;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

import com.dryouch.account.model.Articles;
import com.dryouch.account.model.ArticlesMapper;
import com.dryouch.account.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
public class ArticleDAOImpl implements ArticleDAO {

	JdbcTemplate jdbcTemplate;
	private final String SQL_GET_ARTICLES ="select *  from articles  ";
	private final String SQL_GET_ARTICLES_BY_REF ="select *  from articles where codearticle= ?";
	private final String SQL_GET_ARTICLES_BY_CAT ="select *  from articles  where  categorie=? ";
	private final String SQL_COMMANDER = " insert into commandes (numcommande,codeclient,prix,valider) values(?,?,?,'non')  ";
	private final String SQL_VALIDER_COMMANDE = " UPDATE commandes set valider='oui' where id=?  ";
	private final String SQL_AJOUTER_ARTICLE = " INSERT INTO articles( designation, prix, stock,categorie,photo) VALUES (?,?,?,?,?)  ";
	private final String SQL_SUPPRIMER_ARTICLE ="DELETE FROM articles where codearticle=?" ; 
	@Autowired
	ArticleDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	
	public List <Articles> getArticles() {
		List<Articles> list =  jdbcTemplate.query(SQL_GET_ARTICLES, new ArticlesMapper());
		return list ;
		
	}
	
	
	
	public Articles DetailCatalogue (Long ref) {
	Articles art=  jdbcTemplate.queryForObject(SQL_GET_ARTICLES_BY_REF,new Object[]{ref}, new ArticlesMapper());
		return art ;
}
	
	
	
	
	
	public void Commander(Long ref,String name,int prix) {
	
				jdbcTemplate.update(SQL_COMMANDER, new Object[] { ref,name,prix}) ;
	       }
	
	
	// Find by category 
	
	public List <Articles> getArticlesByCategory(String cat){
		
		List<Articles> list =  jdbcTemplate.query(SQL_GET_ARTICLES_BY_CAT ,new Object[] { cat}, new ArticlesMapper());
		return list ;
		
	}
	
	public void ValiderCommande(int id) {
		
	
			
			jdbcTemplate.update(SQL_VALIDER_COMMANDE, new Object[] {id}) ;
			

		
	}
	public void AjoutArticle(Articles article,byte[]  image) throws SerialException, SQLException {
		Blob blob = new javax.sql.rowset.serial.SerialBlob(image);
		jdbcTemplate.update(SQL_AJOUTER_ARTICLE, new Object[] {article.getDesignation(),article.getPrix(),article.getStock(),article.getCategorie(),blob}) ;
		
	}
	
	public void SupprimerProduit(String ref) {
		
		jdbcTemplate.update(SQL_SUPPRIMER_ARTICLE , new Object[] {ref}) ;
	}
	
		
	
		
	}
	
	

