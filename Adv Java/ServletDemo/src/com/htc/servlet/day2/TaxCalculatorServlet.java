package com.htc.servlet.day2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/taxCalculator")

public class TaxCalculatorServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String pancard=request.getParameter("pcard");
		String empname=request.getParameter("ename");
		String salary=request.getParameter("sal");
		String income1=request.getParameter("income1");
		String income2=request.getParameter("income2");
		
		double totalIncome=(Double.parseDouble(salary)*12 +Double.parseDouble(income1)+Double.parseDouble(income2));
		double standardDeductions=5000.00;
		double taxableIncome = totalIncome- standardDeductions;
		
		request.setAttribute("taxableIncome", new Double(taxableIncome));
		
		RequestDispatcher rd = request.getRequestDispatcher("taxProcessor");
		rd.forward(request, response);
//		response.sendRedirect("taxProcessor");
	}
}
