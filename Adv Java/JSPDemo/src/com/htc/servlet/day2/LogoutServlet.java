package com.htc.servlet.day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
	
		HttpSession session = request.getSession(false);  //existing session.
		if(session != null) 
		{
				session.invalidate();
				response.sendRedirect("login.jsp");
		}
		else 
		{
			pw.println("Invalid Session. <a href='login.jsp'>Login Now</a>.");
		}
//		pw.close();
	}


}
