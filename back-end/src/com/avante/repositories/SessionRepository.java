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
			final String sql = "select * from microblog.session where id_s = " +id;
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        
			ResultSet rs = stmt.executeQuery();
	        Session s = new Session();
	        
	        boolean exists = false;
	        while (rs.next()) {
	        	exists = true;
	        	s.setId(rs.getInt("id_s"));
	        	s.setCookies(rs.getString("cookies"));
	            s.setFecha(rs.getDate("fecha"));
	            s.setUserId(rs.getInt("userId"));
	        }
	        
	        rs.close();
	        stmt.close();
	        return exists ? s : null;
		} catch (SQLException e) {
	        throw new IllegalStateException(e);}
		finally {
			con.close();
		}
	}
	
	public Session insert(Session session) throws SQLException {
		Integer userId = session.getUserId();
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			// Inserting data in database
			String q1 = "insert into Session (fecha, cookies, userId) values(CURDATE(), '', '" + userId + "')";
			PreparedStatement stmt = con.prepareStatement(q1, Statement.RETURN_GENERATED_KEYS);
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			
			rs.next();
			session.setId(rs.getInt(1));

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			con.close();
		}
		return session;
	}

	public boolean eliminar(int id) throws SQLException {
		Session s = new Session();
		Connection con = null;
		boolean eliminar = false;
		String sql = "DELETE FROM microblog.Session WHERE id_s = " + s.getId();
		try {
			con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			eliminar = true;
		} catch (SQLException e) {
			System.out.println("Error: Metodo delete");
			e.printStackTrace();
		} finally {
			con.close();
		}
		return eliminar;
	}

}
