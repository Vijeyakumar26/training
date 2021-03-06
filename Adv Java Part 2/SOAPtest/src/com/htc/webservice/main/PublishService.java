package com.htc.webservice.main;

import javax.xml.ws.Endpoint;

import com.htc.webservice.EmployeeServiceImpl;

public class PublishService 
{
	public static void main(String[] args) 
	{
		Endpoint.publish("http://localhost:1234/employeeService", new EmployeeServiceImpl());
		System.out.println("Employee Service Running.");
	}
}
