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
import com.htc.service.entity.Service;


@WebServlet("/getServiceDetails")
public class GetServiceDetails extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw = response.getWriter();
		response.setContentType("application/xml");


		String serviceId = request.getParameter("serviceid");
		ServiceDAO servicedao = new ServiceDAOImpl();
		Service service = servicedao.getService(serviceId);


		pw.println("<service>");
		pw.println("<serviceid>" + service.getServiceId() + "</serviceid>");
		pw.println("<servicedesc>" + service.getServiceDesc() + "</servicedesc>");
		pw.println("<price>" + service.getPrice()+ "</price>");
		pw.println("<status>" + service.getStatus()+ "</status>");
		pw.println("</service>");

		pw.close();
	}

}
