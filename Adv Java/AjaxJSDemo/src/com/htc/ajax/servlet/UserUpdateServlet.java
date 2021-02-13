package com.htc.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.ajax.dao.UserDAO;
import com.htc.ajax.dao.UserDAOImpl;

@WebServlet("/update")
public class UserUpdateServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();

		response.setContentType("text/html");

		String username= request.getParameter("uname");
		String  address= request.getParameter("address");
		String  contact= request.getParameter("contact");				
		String email= request.getParameter("email");

		UserDAO userDAO = new UserDAOImpl();
		boolean result= userDAO.updateUser(username,address,email,contact);

		if(result)
			pw.println("User updated successfully");

		else
			pw.println("Error while updating user!<br/><br/>");


		pw.println("<a href='userform.html'> Update User Details</a>");
		//pw.close();
	}

}
