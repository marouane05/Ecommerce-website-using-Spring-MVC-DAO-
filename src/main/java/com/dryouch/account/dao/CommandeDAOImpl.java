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
import java.util.Map;

import javax.sql.DataSource;

import com.dryouch.account.model.Commande;
import com.dryouch.account.model.CommandeMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



public class CommandeDAOImpl implements CommandeDAO{
	

	JdbcTemplate jdbcTemplate;
	private final String SQL_GET_ALL ="select  *from  articles a ,commandes c where  c.numcommande=a.codearticle and c.valider='non' and codeclient=?   ";
	private final String SQL_GET_TICKET ="select  *from  articles a ,commandes c where  c.numcommande=a.codearticle and c.valider='oui' and codeclient=?   ";
	private final String SQL_VIDER_PANIER = "delete from commandes where codeclient=?" ; 
	@Autowired
	public CommandeDAOImpl(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	 public List<Commande> getPanier (String name) { 
	// jdbcTemplate.queryForList(SQL_GET_ALL, new Object[] { name }, new CommandeMapper());
		 List <Commande> com = jdbcTemplate.query(SQL_GET_ALL,new Object[] { name }, new CommandeMapper());
		 return com ;
	 }
	 
	 public List<Commande> ticket (String name) {
		 List <Commande> com = jdbcTemplate.query(SQL_GET_TICKET,new Object[] { name }, new CommandeMapper());
	
		 for(int i=0 ; i< com.size() ; i++) {
			 
			com.get(i).setNumber(com.size());
		 }
		 
		 return com ;
	 }
	
	 
public void ViderPanier(String name) {
	
	jdbcTemplate.update(SQL_VIDER_PANIER, new Object[] {name}) ;
	
}
		
	

}
