package com.avante.servlet.user;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avante.beans.AuthBean;
import com.avante.beans.UserBean;
import com.avante.excetions.HttpResponseException;
import com.avante.excetions.NotFoundException;
import com.avante.excetions.UnauthorizedException;
import com.avante.model.Session;
import com.avante.model.User;
import com.avante.services.SessionService;
import com.avante.services.UserService;
import com.google.gson.Gson;


@WebServlet("/data/user/signin")
public class SigninUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SigninUser() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User principal = UserService.get().getPrincipal(request);
			if(principal != null)
				response.getWriter().append(new Gson().toJson(UserBean.toBean(principal)));
			else {
				AuthBean auth = new Gson().fromJson(request.getReader().lines().collect(Collectors.joining()), AuthBean.class);
				User user = UserService.get().get(auth.getEmail());
				if(user == null)
					throw new NotFoundException();
				
				if(!user.getPassword().equals(auth.getPassword()))
					throw new UnauthorizedException();
				
				Session session = new Session();
				session.setFecha(new Date(System.currentTimeMillis()));
				session.setUserId(user.getId());
				session = SessionService.get().save(session);
				
				Cookie cookie = new Cookie("session", ""+session.getId());
				cookie.setPath("/");
				cookie.setHttpOnly(true);
				cookie.setMaxAge(2628000);
				response.addCookie(cookie);
				response.getWriter().append(new Gson().toJson(UserBean.toBean(user)));
			}
				
		} catch(HttpResponseException e) {
			response.setStatus(e.getStatus());
		} catch(Throwable e) {
			response.setStatus(500);
			e.printStackTrace();
		}
	}

}
