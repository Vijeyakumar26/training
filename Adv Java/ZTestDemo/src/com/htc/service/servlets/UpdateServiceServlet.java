package com.htc.service.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.service.dao.ServiceDAO;
import com.htc.service.dao.ServiceDAOImpl;


@WebServlet("/update")
public class UpdateServiceServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw = response.getWriter();

		response.setContentType("text/html");

		String serviceId = request.getParameter("serviceid");
		String  serviceDesc = request.getParameter("servicedesc");
		String  price = request.getParameter("price");				
		String status= request.getParameter("status");

		ServiceDAO serviceDAO = new ServiceDAOImpl();
		boolean result= serviceDAO.updateService(serviceId,serviceDesc,price,status);

		if(result)
			pw.println("Service Details updated successfully");

		else
			pw.println("Error while updated Service Details!<br/><br/>");
	}
}
