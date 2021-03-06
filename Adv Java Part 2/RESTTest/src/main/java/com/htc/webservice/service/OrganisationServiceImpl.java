package com.htc.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.webservice.dao.OrganisationDAO;
import com.htc.webservice.resource.Organisation;

@Service
public class OrganisationServiceImpl implements OrganisationService
{
	@Autowired
	OrganisationDAO orgDAO;

	@Override
	public boolean addOrganisation(Organisation org) 
	{
		return orgDAO.addOrganisation(org);
	}

	@Override
	public Organisation getOrganisation(String orgId)
	{
		return orgDAO.getOrganisation(orgId);
	}

}
