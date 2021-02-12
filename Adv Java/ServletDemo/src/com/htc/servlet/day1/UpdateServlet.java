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


@WebServlet("/updateUser")
public class UpdateServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw  = response.getWriter();
		String uname = request.getParameter("uname");
		String contact = request.getParameter("contact");

		UserDAO userDAO = new UserDAOImpl();
		boolean result = userDAO.updateUser(uname,contact);
		
		if(result)
			pw.println("User updated successfully");
		else
			pw.println("Error while Updating user");

//		pw.close();
	}
}
