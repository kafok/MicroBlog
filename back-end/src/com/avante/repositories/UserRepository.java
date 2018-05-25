package com.avante.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.avante.DatabaseConnectionFactory;
import com.avante.model.User;

public class UserRepository {

	private static UserRepository instance = null;
	
	public static UserRepository get() {
		if(instance == null)
			instance = new UserRepository();
		
		return instance;
	}
	
	private UserRepository() {
		super();
	}
	
	public User get(int id) throws SQLException{
		//get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			final String sql = "select * from microblog.news where id_u = " +id;
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
	        ResultSet rs = stmt.executeQuery(); 
	        User u = new User();
	        
	        while (rs.next()) {
	        	u.setId(rs.getInt("id_u"));
	        	u.setEmail(rs.getString("email"));
	            u.setPassword(rs.getString("password"));
	            u.setProfile(rs.getString("profile"));;
	            
	        }
	        
	        rs.close();
	        stmt.close();
	        return u;
		} catch (SQLException e) {
	        throw new IllegalStateException(e);}
		finally {
			con.close();
		}
	}
	
	
}
