package com.avante.servlet.news;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avante.beans.NewsBean;
import com.avante.excetions.HttpResponseException;
import com.avante.model.News;
import com.avante.services.ListUserNewsService;
import com.avante.services.UserService;
import com.google.gson.Gson;


@WebServlet("/data/news/listByUser")
public class ListUserNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ListUserNews() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int limit = Integer.parseInt(request.getParameter("limit"));
			int offset = Integer.parseInt(request.getParameter("offset"));
			List<NewsBean> res = new LinkedList<>();
			for(News n : ListUserNewsService.get().listByUser(id,limit, offset)) {
				res.add(NewsBean.toBean(n, UserService.get().get(n.getUserId()).getName()));
			}
			
			response.getWriter().append(new Gson().toJson(res));
			response.setContentType("application/json");
		} catch(HttpResponseException e) {
			response.setStatus(e.getStatus());
		} catch(Throwable e) {
			response.setStatus(500);
			e.printStackTrace();
		}
	}

}
