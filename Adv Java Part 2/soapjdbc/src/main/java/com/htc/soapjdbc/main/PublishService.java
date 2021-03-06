package com.htc.soapjdbc.main;

import javax.xml.ws.Endpoint;

import com.htc.soapjdbc.service.TouristServiceImpl;


public class PublishService 
{
	public static void main(String[] args) 
	{
		Endpoint.publish("http://localhost:1235/touristService", new TouristServiceImpl());
		System.out.println("Tourist Service is Up and Running!!");
	}
}
