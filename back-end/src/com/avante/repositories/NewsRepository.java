package com.avante.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.avante.servlet.news.*;

import com.avante.DatabaseConnectionFactory;
import com.avante.model.News;

public class NewsRepository {

	private static NewsRepository instance = null;
	
	public static NewsRepository get() {
		if(instance == null)
			instance = new NewsRepository();
		
		return instance;
	}
	
	private NewsRepository() {
		super();
	}
	
	public News get(int id) throws SQLException{
		//get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			final String sql = "select * from microblog.news where id = " +id;
			//create prepared statement with option to get auto generated keys
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.execute();
			//Get auto generated keys
	        ResultSet rs = stmt.getGeneratedKeys(); 
	        News n = new News();
	        
	        while (rs.next()) {
	        	n.setId(rs.getInt("id_n"));
	        	n.setFecha(rs.getDate("fecha"));
	            n.setTitulo(rs.getString("titulo"));
	            n.setDescripcion(rs.getString("descripcion"));;
	            n.setUserId(rs.getInt("userId"));
	        }
	        
	        rs.close();
	        stmt.close();
	        return n;
		} catch (SQLException e) {
	        throw new IllegalStateException(e);}
		finally {
			con.close();
		}
	}
//	public News insert() throws SQLException{
//		//get connection from connection pool
//		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
//		try
//	}
	
	
}

