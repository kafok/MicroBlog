package com.avante.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avante.beans.UserBean;
import com.avante.excetions.HttpResponseException;
import com.avante.excetions.NotFoundException;
import com.avante.model.User;
import com.avante.services.UserService;
import com.google.gson.Gson;


@WebServlet("/data/user/principal")
public class PrincipalUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PrincipalUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User principal = UserService.get().getPrincipal(request);
			if(principal == null)
				throw new NotFoundException();
				
			response.getWriter().append(new Gson().toJson(UserBean.toBean(principal)));	
		} catch(HttpResponseException e) {
			response.setStatus(e.getStatus());
		} catch(Throwable e) {
			response.setStatus(500);
		}
	}

}
