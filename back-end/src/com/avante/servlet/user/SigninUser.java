package com.avante.servlet.user;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avante.beans.UserBean;
import com.avante.excetions.HttpResponseException;
import com.avante.excetions.NotFoundException;
import com.avante.excetions.UnauthorizedException;
import com.avante.model.Session;
import com.avante.model.User;
import com.avante.services.SessionService;
import com.avante.services.UserService;
import com.google.gson.Gson;


@WebServlet("/data/user/singin")
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
				User user = UserService.get().get(request.getParameter("email"));
				if(user == null)
					throw new NotFoundException();
				
				if(!user.getPassword().equals(request.getParameter("password")))
					throw new UnauthorizedException();
				
				Session session = new Session();
				session.setFecha(new Date(System.currentTimeMillis()));
				session.setUserId(user.getId());
				session = SessionService.get().save(session);
				
				response.addCookie(new Cookie("session", ""+session.getId()));
			}
				
		} catch(HttpResponseException e) {
			response.setStatus(e.getStatus());
		} catch(Throwable e) {
			response.setStatus(500);
			e.printStackTrace();
		}
	}

}
