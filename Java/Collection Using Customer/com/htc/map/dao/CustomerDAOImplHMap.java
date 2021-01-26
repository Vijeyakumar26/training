package com.htc.map.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.map.entity.Customer;

public class CustomerDAOImplHMap implements CustomerDAO
{
	Map<Integer,Customer> hmap = new HashMap<Integer,Customer>();
	
	@Override
	public boolean addCustomer(int customerId,Customer cus) 
	{
		boolean flag = false;
		if(cus!=null)
		{
			hmap.put(customerId, cus);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateCustomer(int customerId, String mail) throws CustomerNotFoundException
	{
		boolean flag = false;

		try {
			if(!hmap.containsKey(customerId))
			{
				throw new CustomerNotFoundException();
			}
			else
			{
				hmap.get(customerId).setMailId(mail);
				flag = true;
			}
		}
		catch(CustomerNotFoundException e)
		{
			System.out.println(" for Updating.");
		}
		return flag;
	}
	

	@Override
	public boolean deleteCustomer(int customerId) throws CustomerNotFoundException
	{
		boolean flag = false;
		try {
			if(!hmap.containsKey(customerId))
			{
				throw new CustomerNotFoundException();
			}
			else
			{
				hmap.remove(customerId);
				flag = true;
			}
		}
		catch(CustomerNotFoundException e)
		{
			System.out.println(" for deletion");
		}
		return flag;
	}

	@Override
	public Map<Integer, Customer> getAllCustomers() 
	{
		return hmap;
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException
	{
		Customer cus = null;
		if(!hmap.containsKey(customerId))
		{
			throw new CustomerNotFoundException();
		}
		else
		{
			cus = hmap.get(customerId);
		}
		return cus;
	}
}
