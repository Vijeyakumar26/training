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

@WebServlet("/checkUsername")
public class CheckUserNameServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
//		response.setContentType("text/plain"); //sendGetRequest()
		response.setContentType("application/xml");  //sendGetRequest2()
		String msg = "";

		String uname = request.getParameter("uname");
		UserDAO userDAO = new UserDAOImpl();

		boolean userFound = userDAO.checkUsername(uname);
		if(userFound)
		{
//			msg = "Username already exist!";
			pw.println("<MESSAGE>EXISTS</MESSAGE>");
		}
		else
		{
			pw.println("<MESSAGE>NOT-EXISTS</MESSAGE>");
		}
		pw.println(msg);
		pw.close();
	}
}
