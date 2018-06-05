package com.avante.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
	//Get News by ID
	public News get(int id) throws SQLException{
		//get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			final String sql = "select * from microblog.news where id_n = " +id;
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
	        ResultSet rs = stmt.executeQuery();
	        News n = new News();
	        
	        boolean exists = false;
	        while (rs.next()) {
	        	exists = true;
	        	n.setId(rs.getInt("id_n"));
	        	n.setFecha(rs.getDate("fecha"));
	            n.setTitulo(rs.getString("titulo"));
	            n.setDescripcion(rs.getString("descripcion"));;
	            n.setUserId(rs.getInt("userId"));
	        }
	        
	        rs.close();
	        stmt.close();
	        return exists ? n : null;
		} catch (SQLException e) {
	        throw new IllegalStateException(e);}
		finally {
			con.close();
		}
	}
	//CREATE
	public News insert(News news) throws SQLException{
		Integer id = news.getId();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy ");
		Date fecha = Calendar.getInstance().getTime(); 
		String reportDate = df.format(fecha);
		System.out.println("Report Date: " + reportDate);
        
        String titulo = news.getTitulo();
        String descripcion = news.getDescripcion();
        Integer userId = news.getUserId();
      //get connection from connection pool
      	Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection(); 
        try
        {
        	// Inserting data in database
            String q1 = "insert into News (id, fecha, titulo, descripcion, userId) values('" +id+ "', '" +fecha+ 
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
	//UPDATE
	public boolean actualizar(News news) {
		Connection con =null;
		Statement stm =null;
		boolean actualizar=false;
		
		String sql="UPDATE microblog.news SET titulo = '"+news.getTitulo()+"',descripcion='"+news.getDescripcion()+"', fecha='"+news.getFecha()+"'"+"WHERE ID="+news.getId();
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
	//DELETE
	public boolean eliminar(int id) {
		News n = new News();
		Connection con = null;
		Statement stm = null;
		boolean eliminar= false;
		
		String sql = "DELETE FROM microblog.news WHERE ID="+n.getId();
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

	// Get List All News Paginated
	public List<News> getAllNews(int limit, int offset) {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM microblog.news LIMIT " + limit + " OFFSET " + offset;
		List<News> listaNews = new ArrayList<>();
		News n = new News();
		try {
			con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				n = new News();
				n.setId(rs.getInt("id_n"));
				n.setFecha(rs.getDate("fecha"));
				n.setTitulo(rs.getString("titulo"));
				n.setDescripcion(rs.getString("descripcion"));
				n.setUserId(rs.getInt("userId"));
				listaNews.add(n);
			}

			rs.close();
			stm.close();

		} catch (SQLException e) {
			System.out.println("Error: Metodo listar todas las noticias");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return listaNews;
	}

	
}

