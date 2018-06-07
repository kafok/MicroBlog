package com.avante.servlet.news;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avante.beans.NewsBean;
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
			NewsBean news = new Gson().fromJson(request.getReader().lines().collect(Collectors.joining()), NewsBean.class);
			News res = NewsService.get().save(NewsService.get().fromBean(news), request);
			response.getWriter().append(new Gson().toJson(NewsBean.toBean(res, null)));	
			response.setContentType("application/json");
		} catch(HttpResponseException e) {
			response.setStatus(e.getStatus());
		} catch(Throwable e) {
			response.setStatus(500);
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			for(int i=0; i<40; i++) {
				News res = new News();
				res.setTitulo("Titulo " + i);
				res.setDescripcion("Descripcion " + i);
				NewsService.get().save(res, request);
			}
		} catch(HttpResponseException e) {
			response.setStatus(e.getStatus());
		} catch(Throwable e) {
			response.setStatus(500);
			e.printStackTrace();
		}
	}

}
