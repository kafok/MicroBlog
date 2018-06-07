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

public class ListUserNewsService {

	private static ListUserNewsService instance = null;
	
	public static ListUserNewsService get() {
		if(instance == null)
			instance = new ListUserNewsService();
		
		return instance;
	}
	
	private ListUserNewsService() {
		super();
	}
	
	
	public News get(int id) throws SQLException {
		News res = NewsRepository.get().get(id);
		if(res == null)
			throw new NotFoundException();
		
		return res;
	}
	
	public Collection<News> listByUser(int id,int limit, int offset) {
		return NewsRepository.get().getListNewsByUser(id,limit, offset);
	}
	
	public News save(News news, HttpServletRequest request) throws SQLException {
		User principal  = UserService.get().getPrincipal(request);
		if(principal == null)
			throw new UnauthorizedException();
			
		news.setUserId(principal.getId());
		if(news.getId() == 0) {
			news.setFecha(new Date(System.currentTimeMillis()));
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
		
		res.setDescripcion(bean.getDescripcion());
		res.setFecha(new Date(bean.getFecha()));
		res.setTitulo(bean.getTitulo());
		
		return res;
	}
}
