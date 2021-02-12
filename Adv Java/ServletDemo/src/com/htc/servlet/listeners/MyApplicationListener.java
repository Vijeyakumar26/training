package com.htc.servlet.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyApplicationListener
 *
 */
@WebListener
public class MyApplicationListener implements ServletContextListener 
{
   
    public void contextDestroyed(ServletContextEvent event) 
    { 
    	System.out.println("Application destroyed.....");
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
    }

    public void contextInitialized(ServletContextEvent event) 
    { 
    	System.out.println("Application starting...");
    	
    	ServletContext context = event.getServletContext();
    	context.setAttribute("userCount", new Integer(0));
    }
}
