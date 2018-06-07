package com.avante.servlet.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avante.beans.NewsBean;
import com.avante.excetions.HttpResponseException;
import com.avante.model.News;
import com.avante.services.NewsService;
import com.avante.services.UserService;
import com.google.gson.Gson;


@WebServlet("/data/news/get")
public class GetNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetNews() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			News res = NewsService.get().get(Integer.parseInt(request.getParameter("id")));
			response.getWriter().append(new Gson().toJson(NewsBean.toBean(res, UserService.get().get(res.getUserId()).getName())));	
			response.setContentType("application/json");
		} catch(HttpResponseException e) {
			response.setStatus(e.getStatus());
		} catch(Throwable e) {
			response.setStatus(500);
			e.printStackTrace();
		}
	}

}
