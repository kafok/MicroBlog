package com.avante.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


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
	public Session insert(Session session) throws SQLException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy ");
		Date fecha = Calendar.getInstance().getTime(); 
		String reportDate = df.format(fecha);
		System.out.println("Report Date: " + reportDate);
        
        
        String cookies = session.getCookies();
        Integer userId =session.getUserId();
      //get connection from connection pool
      	Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection(); 
        try
        {
        	// Inserting data in database
            String q1 = "insert into News values('" +fecha+ "', '" +cookies+ 
                                  "', '" +userId+ "')";
        	PreparedStatement stmt = con.prepareStatement(q1, Statement.RETURN_GENERATED_KEYS);
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys(); 
            
            int x = stmt.executeUpdate(q1);
            if (x > 0)            
                System.out.println("Successfully Inserted");            
            else           
                System.out.println("Insert Failed");
             
            
            rs.close();
	        stmt.close();
        }
        catch(SQLException e)
        {
        	throw new IllegalStateException(e);
        }finally {
			con.close();
		}
		return session;
	}
	public boolean eliminar(int id) {
		Session s = new Session();
		Connection con = null;
		Statement stm = null;
		boolean eliminar= false;
		String sql = "DELETE FROM NEWS WHERE ID="+s.getId();
		try {
			con=DatabaseConnectionFactory.getConnectionFactory().getConnection();
			stm=con.createStatement();
			stm.execute(sql);
			eliminar =true;
		}catch(SQLException e) {
			System.out.println("Error: Metodo delete");
			e.printStackTrace();
		}
		return eliminar;
	}
	
}
