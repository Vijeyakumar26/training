package com.htc.webservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.htc.webservice.resource.Organisation;

@Repository
public class OrganisationDAOImpl implements OrganisationDAO
{
	List<Organisation> orgList =new ArrayList<>();
	@Override
	public boolean addOrganisation(Organisation org) 
	{
		return orgList.add(org);
	}

	@Override
	public Organisation getOrganisation(String orgId)
	{
		Organisation tp = null;
		for(Organisation org: orgList) {
			if(org.getOrgId().equals(orgId)) {
				tp = org;
				break;
			}
		}
		return tp;
	}

}
