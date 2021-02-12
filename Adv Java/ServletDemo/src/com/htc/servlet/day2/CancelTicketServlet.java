package com.htc.servlet.day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cancelTicket")
public class CancelTicketServlet extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
	
		HttpSession session = request.getSession(false);  //existing session.
		if(session != null) 
		{
			String username = (String)session.getAttribute("username");
			pw.println("<h2> Welcome " + username+ "</h2>");	
			
			pw.println("<h2> Cancel Ticket Screen</h2>");
			pw.print("<a href='logout'>Logout</a>");

		}
		else {
			pw.println("Invalid Session. <a href='login.html'>Login Now</a>.");
		
		}
//		pw.close();
	}
}
