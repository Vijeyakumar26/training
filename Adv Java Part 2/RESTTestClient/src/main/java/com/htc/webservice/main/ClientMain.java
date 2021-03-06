package com.htc.webservice.main;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.htc.webservice.resource.Organisation;

public class ClientMain {
	
	public static String getOrganisationURL = "http://localhost:8080/getOrganisation/";	
	public static String addOrganisationURL = "http://localhost:8080/addOrganisation/";
	
	
	public static void main(String[] args) {
		
		RestTemplate template = new RestTemplate();
		
		//addOrganisation
		Organisation orgAdd = new Organisation("100","HTC","TamilNadu","21312","Karthick","abca@gmail.com");
		Organisation orgAdd1 = new Organisation("102","DELL","Banglore","2131234","Radha","aDEll@gmail.com");
		boolean status=template.postForObject(addOrganisationURL,orgAdd,Boolean.class);
		
		if(status)
		{
			System.out.println("Created....!!");
		}
		
		//getById
		ResponseEntity<Organisation> response = template.getForEntity(getOrganisationURL+"102", Organisation.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());		
		System.out.println(response.getHeaders().toString());
	}
}
