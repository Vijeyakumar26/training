package com.htc.service.dao;

import java.util.List;
import com.htc.service.entity.Service;


public interface ServiceDAO
{
	public boolean checkServiceId(String serviceId);
	public Service getService(String serviceId);
	public boolean updateService(String serviceId, String serviceDesc, String price, String status);
	public List<Service> getAllServiceDetails();
}
