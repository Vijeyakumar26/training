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
import com.htc.ajax.entity.User;


@WebServlet("/getUserDetails")
public class GetUserServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw = response.getWriter();
		response.setContentType("application/xml");


		String uname = request.getParameter("uname");
		UserDAO userdao = new UserDAOImpl();
		User user = userdao.getUser(uname);


		pw.println("<user>");
		pw.println("<username>" + user.getUsername()+ "</username>");
		pw.println("<pwd>" + user.getPassword()+ "</pwd>");
		pw.println("<address>" + user.getAddress()+ "</address>");
		pw.println("<email>" + user.getEmail()+ "</email>");
		pw.println("<contact>" + user.getContactno()+ "</contact>");
		pw.println("<gender>" + user.getGender()+ "</gender>");
		pw.println("</user>");

		pw.close();
	}
}
