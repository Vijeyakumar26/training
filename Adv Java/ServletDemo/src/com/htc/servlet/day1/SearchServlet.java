package com.htc.servlet.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.servlet.bo.User;
import com.htc.servlet.dao.UserDAO;
import com.htc.servlet.dao.UserDAOImpl;


@WebServlet("/searchUser")
public class SearchServlet extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("uname");
		
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.getUser(username);
		
		pw.println("<h2> User Details</h2>");
//		pw.println("<table class='table table-striped'>");
		pw.println("<tr><td>Username </td><td>"+ user.getUsername()+ "</td></tr><br/>");
		pw.println("<tr><td>Password </td><td> ******* </td></tr><br/>");
		pw.println("<tr><td>Address </td><td>"+ user.getAddress()+ "</td></tr><br/>");
		pw.println("<tr><td>Phone </td><td>"+ user.getContactno()+ "</td></tr><br/>");
		pw.println("<tr><td>Email </td><td>"+ user.getEmail()+ "</td></tr><br/>");
		pw.println("<tr><td>Gender </td><td>"+ user.getGender()+ "</td></tr><br/>");
		
		pw.println("</table>");
//		pw.close();
	}

}
