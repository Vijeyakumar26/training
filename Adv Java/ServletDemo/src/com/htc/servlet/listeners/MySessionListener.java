package com.htc.servlet.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) 
    { 
    	System.out.println("Session created!!");
		HttpSession session = event.getSession();
		ServletContext context = session.getServletContext();
		Integer userCount = (Integer) context.getAttribute("userCount");
		userCount++;
		
		context.setAttribute("userCount", userCount);
    }

    public void sessionDestroyed(HttpSessionEvent event) 
    { 
    	System.out.println("Session destroyed!!");
		HttpSession session = event.getSession();
		ServletContext context = session.getServletContext();
		Integer userCount = (Integer) context.getAttribute("userCount");
		userCount--;
		
		context.setAttribute("userCount", userCount);
    }
}
