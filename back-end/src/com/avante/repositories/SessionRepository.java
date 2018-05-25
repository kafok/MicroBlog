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
			final String sql = "select * from microblog.news where id_s = " +id;
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        
			ResultSet rs = stmt.executeQuery();
	        Session s = new Session();
	        
	        while (rs.next()) {
	        	s.setId(rs.getInt("id_s"));
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
