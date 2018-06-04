package com.avante.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

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
	public News insert(News news) throws SQLException{
		Integer id = news.getId();
        Date fecha = news.getFecha();
        String titulo = news.getTitulo();
        String descripcion = news.getDescripcion();
        Integer userId = news.getUserId();
      //get connection from connection pool
      	Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection(); 
        try
        {
        	// Inserting data in database
            String q1 = "insert into News values('" +id+ "', '" +fecha+ 
                                  "', '" +titulo+ "', '" +descripcion+ "', '"+userId+"')";
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
		return news;
	}
	public boolean actualizar(News news) {
		Connection con =null;
		Statement stm =null;
		boolean actualizar=false;
		
		String sql="UPDATE NEWS SET titulo = '"+news.getTitulo()+"',descripcion='"+news.getDescripcion()+"', fecha='"+news.getFecha()+"'"+"WHERE ID="+news.getId();
		try {
			con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
			stm=con.createStatement();
			stm.execute(sql);
			actualizar=true;
		}catch(SQLException e) {
			System.out.println("Error: metodo actualizar");
			e.printStackTrace();
		}return actualizar;
	}
	public boolean eliminar(News news) {
		Connection con = null;
		Statement stm = null;
		boolean eliminar= false;
		String sql = "DELETE FROM NEWS WHERE ID="+news.getId();
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

