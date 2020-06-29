package com.dryouch.account.model;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CommandeMapper implements RowMapper<Commande> {

	
	@Override
	public Commande mapRow(ResultSet res, int rowNum) throws SQLException {
	
		Commande  com = new Commande();
		/* person.setId(resultSet.getLong("id"));
		person.setFirstName(resultSet.getString("first_name"));
		person.setLastName(resultSet.getString("last_name"));
		person.setAge(resultSet.getInt("age"));
		return person;
*/
		    com.setId(res.getInt("id"));
		    com.setNumcommande(res.getInt("codearticle"));
	        com.setCodeclient(res.getString("codeclient"));
	        com.setDesignation(res.getString("a.designation"));
	        com.setDatecommande(res.getDate("datecommande"));
	        com.setPrix(res.getInt("prix")); 
	        com.setNumber(0);
		
	        return com ;
	
	}
	
}
