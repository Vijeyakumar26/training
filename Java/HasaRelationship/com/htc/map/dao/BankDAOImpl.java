package com.htc.map.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.htc.map.entity.BankMap;
import com.htc.map.entity.CustomerMap;
import com.htc.map.main.MainClassMap;


public class BankDAOImpl implements BankDAO
{

	Map<String, List<CustomerMap>> mapobj = new HashMap<>();
	Logger logger = Logger.getLogger(MainClassMap.class.getName());

	@Override
	public boolean addEmployee(BankMap b)
	{
		boolean flag = false;
		if(b==null)
		{
			logger.severe("no data to insert");
		}
		else
		{
			mapobj.put(b.getBankid(), b.getCus());
			logger.info("Data stored successfully");
			flag=true;
		}
		return flag;
	}

	@Override
	public Map<String, List<CustomerMap>> getAllEmpInThisDept()
	{
		return mapobj;
	}

}
