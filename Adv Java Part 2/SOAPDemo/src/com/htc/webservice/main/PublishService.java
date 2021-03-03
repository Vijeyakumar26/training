package com.htc.webservice.main;

import javax.xml.ws.Endpoint;

import com.htc.webservice.TouristServiceImpl;

public class PublishService 
{
	public static void main(String[] args) 
	{
		Endpoint.publish("http://localhost:1234/touristService", new TouristServiceImpl());
		System.out.println("Tourist Service is Up and Running!!");
	}
}
