package com.avante.services;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.avante.beans.NewsBean;
import com.avante.excetions.NotFoundException;
import com.avante.excetions.UnauthorizedException;
import com.avante.model.News;
import com.avante.model.User;
import com.avante.repositories.NewsRepository;

public class NewsService {

	private static NewsService instance = null;
	
	public static NewsService get() {
		if(instance == null)
			instance = new NewsService();
		
		return instance;
	}
	
	private NewsService() {
		super();
	}
	
	
	public News get(int id) throws SQLException {
		News res = NewsRepository.get().get(id);
		if(res == null)
			throw new NotFoundException();
		
		return res;
	}
	
	public Collection<News> list(int limit, int offset) {
		return NewsRepository.get().getAllNews(limit, offset);
	}
	
	public News save(News news, HttpServletRequest request) throws SQLException {
		User principal  = UserService.get().getPrincipal(request);
		if(principal == null)
			throw new UnauthorizedException();
			
		if(news.getId() == 0) {
			return NewsRepository.get().insert(news);
		} else {
			if(principal.getId() != this.get(news.getId()).getUserId())
				throw new UnauthorizedException();
			
			NewsRepository.get().actualizar(news);
			return news;
		}
	}
	
	public void delete(int id, HttpServletRequest request) throws SQLException {
		User principal  = UserService.get().getPrincipal(request);
		if(principal == null)
			throw new UnauthorizedException();
		
		if(principal.getId() != this.get(id).getUserId())
			throw new UnauthorizedException();
		
		//NewsRepository.get().eliminar(news)
	}
	
	public News fromBean(NewsBean bean) throws SQLException {
		News res;
		if(bean.getId() == 0) {
			res = new News();
			res.setUserId(bean.getUserId());
		} else
			res = this.get(bean.getId());
		
		res.setDescripcion(bean.getDescription());
		res.setFecha(new Date(bean.getDate()));
		res.setTitulo(bean.getTitle());
		
		return res;
	}
}
