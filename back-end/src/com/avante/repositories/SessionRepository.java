package com.avante.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.avante.DatabaseConnectionFactory;
import com.avante.model.Session;

public class SessionRepository {

	private static SessionRepository instance = null;
	
	public static SessionRepository get() {
		if(instance == null)
			instance = new SessionRepository();
		
		return instance;
	}
	
	private SessionRepository() {
		super();
	}
	public Session get(int id) throws SQLException{
		//get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			final String sql = "select * from microblog.news where id = " +id;
			//create prepared statement with option to get auto generated keys
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.execute();
			//Get auto generated keys
	        ResultSet rs = stmt.getGeneratedKeys(); 
	        Session s = new Session();
	        
	        while (rs.next()) {
	        	s.setId(rs.getInt("id_n"));
	        	s.setCookies(rs.getString("cookies"));
	            s.setFecha(rs.getDate("fecha"));
	            s.setUserId(rs.getInt("userId"));
	        }
	        
	        rs.close();
	        stmt.close();
	        return s;
		} catch (SQLException e) {
	        throw new IllegalStateException(e);}
		finally {
			con.close();
		}
	}
	
	
}
