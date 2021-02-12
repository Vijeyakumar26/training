package com.htc.servlet.day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/taxProcessor")
public class TaxProcessorServlet extends HttpServlet
{	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		Double taxableIncome = (Double)request.getAttribute("taxableIncome");
		double tax = 0 ;
		
		if( taxableIncome>1000000)
		{
			tax = taxableIncome * 20/100;
		}
		else if(taxableIncome>750001 && taxableIncome<1000000)
		{
			tax = taxableIncome * 15/100;
		}
		else if(taxableIncome>500001 && taxableIncome<750000)
		{
			tax = taxableIncome * 10/100;
		}
		else if(taxableIncome>250001 && taxableIncome<500000)
		{
			tax = taxableIncome * 5/100;
		}
		else
		{
			tax = taxableIncome;
		}

		pw.println ("<h2>INCOME TAX REPORT</h2>");
		pw.println("<br/>Pancard : "+request.getParameter("pcard"));
		pw.println("<br/>Employee name: "+request.getParameter("ename"));
		pw.println("<br/>Salary : "+request.getParameter("sal"));
		pw.println("<br/>Income1 : "+request.getParameter("income1"));
		pw.println("<br/>Income2 : "+request.getParameter("income2"));
		pw.println("<br/>Taxable Income : " + taxableIncome);
		pw.println("<br/>Tax : "+ tax);
		
//		pw.close();

	}
}
