package com.htc.servlet.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet
{       
	@Override
	public void destroy() 
	{
		super.destroy();
	}

	@Override
	public void init() throws ServletException
	{
		System.out.println("Servlet Intialized");
		super.init();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<center><h1>Welcome to Servlet Application</h1></center>");
		out.print("<center><a href =register.html>Register User</a></center>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
