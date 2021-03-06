package com.htc.webservice.service;

import com.htc.webservice.resource.Organisation;

public interface OrganisationService 
{
	public boolean addOrganisation(Organisation org);
	public Organisation getOrganisation(String orgId);
}
