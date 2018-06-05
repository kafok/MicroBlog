package com.avante.servlet.news;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avante.excetions.HttpResponseException;
import com.avante.model.News;
import com.avante.services.NewsService;
import com.google.gson.Gson;


@WebServlet("/data/news/save")
public class SaveNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaveNews() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			News news = new Gson().fromJson(request.getReader().lines().collect(Collectors.joining()), News.class);
			NewsService.get().save(news, request);
		} catch(HttpResponseException e) {
			response.setStatus(e.getStatus());
		} catch(Throwable e) {
			response.setStatus(500);
			e.printStackTrace();
		}
	}

}
