package com.htc.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.webservice.resource.Organisation;
import com.htc.webservice.service.OrganisationService;

@RestController
public class OrganisationController 
{
	@Autowired
	OrganisationService orgService;
	
	@PostMapping(value="/addOrganisation", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addOrganisation(@RequestBody Organisation org) {
		
		
		HttpHeaders header = new HttpHeaders();		
		header.add("Access-Control-Allow-Origin","*");		
		header.add("Access-Control-Allow-Methods","GET,PUT,POST,DELETE,OPTIONS");		
		header.add("Access-Control-Allow-Headers","Content-Type");			
				
		boolean result = orgService.addOrganisation(org);
		
		return new ResponseEntity<Boolean>(result,header,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getOrganisation/{orgId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Organisation> getOrganisation(@PathVariable(name="orgId") String orgId) {
		
		HttpHeaders header = new HttpHeaders();
		header.add("Access-Control-Allow-Origin", "*");
		header.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		header.add("Access-Control-Allow-Headers", "Content-Type");	
		
		Organisation tp = orgService.getOrganisation(orgId);
		if(tp == null)
		{
			ResponseEntity<Organisation> response = new ResponseEntity<>(header,HttpStatus.NO_CONTENT);
			return response;
		}
		else
		{
			ResponseEntity<Organisation> response = new ResponseEntity<Organisation>(tp,header,HttpStatus.OK);
			return response;
		}
		
	}
}
