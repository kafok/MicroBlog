package com.avante.servlet;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.avante.DatabaseConnectionFactory;


@WebListener
public class InitServlet implements ServletContextListener {
	
    public void contextInitialized(ServletContextEvent event) {
    	try {
			DatabaseConnectionFactory.getConnectionFactory().init();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
    }
    
    public void contextDestroyed(ServletContextEvent event) {
    }
}