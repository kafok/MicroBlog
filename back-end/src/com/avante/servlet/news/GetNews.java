package com.avante.servlet.news;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avante.repositories.NewsRepository;
import com.google.gson.Gson;


@WebServlet("/data/news/get")
public class GetNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetNews() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		} catch(Throwable e) {
			response.setStatus(500);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
