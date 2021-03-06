package com.htc.webservice.dao;

import com.htc.webservice.resource.Organisation;

public interface OrganisationDAO 
{
	public boolean addOrganisation(Organisation org);
	public Organisation getOrganisation(String orgId);
}
