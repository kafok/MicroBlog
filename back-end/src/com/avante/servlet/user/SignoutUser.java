package com.avante.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/data/user/signout")
public class SignoutUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SignoutUser() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if(cookies == null)
			return;
		
		Cookie cookie = null;
		for(Cookie c : cookies) {
			if(c.getName().equals("session")) {
				cookie = c;
				break;
			}
		}
		
		cookie.setValue("0");
		cookie.setMaxAge(-1000);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

}
