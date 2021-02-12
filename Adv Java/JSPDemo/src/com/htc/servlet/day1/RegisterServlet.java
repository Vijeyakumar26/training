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


@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw  = response.getWriter();

		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");

		User user = new User(uname, pwd, address, contact, email,gender);

		UserDAO userDAO = new UserDAOImpl();
		boolean result = userDAO.addUser(user);

		if(result)
			response.sendRedirect("registerSuccess.jsp");
//			pw.println("User created successfully");
		else
			pw.println("Error while registering user");

//		pw.close();
	}
}
