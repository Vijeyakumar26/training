package com.htc.servlet.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*")
public class HeaderFooterFilter implements Filter {

  
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		HttpServletResponse res = (HttpServletResponse) response;
  		PrintWriter pw = res.getWriter();
  		
  		pw.println("<center><h1> HTC Global Services India Pvt Ltd.<h1>");
  		pw.print("<h3>SDF II, Phase II, MEPZ, Tambram, Chennai-45</h3></center>");
  	
  		chain.doFilter(request, response);
  		pw.close();
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
