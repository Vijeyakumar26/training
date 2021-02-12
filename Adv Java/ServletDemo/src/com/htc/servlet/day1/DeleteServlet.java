package com.htc.servlet.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.servlet.dao.UserDAO;
import com.htc.servlet.dao.UserDAOImpl;


@WebServlet("/deleteUser")
public class DeleteServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw  = response.getWriter();
		String uname = request.getParameter("uname");
		
		UserDAO userDAO = new UserDAOImpl();
		boolean result = userDAO.deleteUser(uname);

		if(result)
			pw.println("User deleted successfully");
		else
			pw.println("Error while deleting user");

//		pw.close();
	}
}
