package com.dryouch.account.model;
import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.springframework.jdbc.core.RowMapper;
public class ArticlesMapper implements RowMapper<Articles>{

	@Override
	public Articles mapRow(ResultSet res, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		  Articles art = new Articles();	
		try {
			 Blob blob = res.getBlob("photo");
			 InputStream inputStream = blob.getBinaryStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             byte[] buffer = new byte[4096];
             int bytesRead = -1;
              
             while ((bytesRead = inputStream.read(buffer)) != -1) {
                 outputStream.write(buffer, 0, bytesRead);                  
             }
              
             byte[] imageBytes = outputStream.toByteArray();
             String base64Image = Base64.getEncoder().encodeToString(imageBytes);
              
              
             inputStream.close();
             outputStream.close();
           
             
                art.setCategorie(res.getString("categorie"));
				art.setCodearticle(res.getLong("codearticle"));
				art.setDesignation(res.getString("designation"));
				art.setPrix(res.getInt("prix"));
				art.setStock(res.getString("stock"));
		        art.setImage(base64Image);
   
   

		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art ;
	}
	
	

}
