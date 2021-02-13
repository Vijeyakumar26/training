package com.htc.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.ajax.dao.UserDAO;
import com.htc.ajax.dao.UserDAOImpl;
import com.htc.ajax.entity.User;

/**
 * Servlet implementation class GetAllUserServlet
 */
@WebServlet("/GetAllUserServlet")
public class GetAllUserServlet extends HttpServlet
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		response.setContentType("application/xml");

		UserDAO userdao = new UserDAOImpl();
		List<User> users = userdao.getAllUsers();
		
		pw.println("<users>");
		for(User user : users)
		{
			pw.println("<user>");
			pw.println("<username>" + user.getUsername() + "</username>");
			pw.println("</user>");
		}
		pw.println("</users>");
	}
}
