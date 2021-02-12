package com.htc.servlet.day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.htc.servlet.dao.UserDAO;
import com.htc.servlet.dao.UserDAOImpl;


@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw  = response.getWriter();

		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");

		UserDAO userDAO = new UserDAOImpl();
		boolean validStatus = userDAO.validateUser(uname, pwd);

		if(validStatus)
		{
			HttpSession session = request.getSession(true);   // New Session always.
			session.setAttribute("username", uname);
			session.setMaxInactiveInterval(60);  //in seconds
			System.out.println(session.getId());
		
		
			pw.println("<h2>Welcome  - " + uname + "</h2>");

			String bookTicket = response.encodeURL("bookTicket");
			String cancelTicket = response.encodeURL("cancelTicket");
			String logout = response.encodeURL("logout");

			System.out.println(bookTicket + "," + cancelTicket);

			pw.println("<a href='" + bookTicket +"'>Book Ticket</a> <br/><br/>");
			pw.println("<a href='" + cancelTicket+ "'>Cancel Ticket <br/> <br/>");
			pw.print("<a href='" + logout+ "'>Logout</a>");

//			pw.close();	
		}	
		else
		{
			System.out.println("Invalid Login");
			response.sendRedirect("login.html");
		}

	}

}
