package com.htc.map.dao;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.map.entity.Customer;

public class CustomerDAOImplTMap implements CustomerDAO 
{
	Map<Integer,Customer> tmap = new TreeMap<Integer,Customer>();
	
	@Override
	public boolean addCustomer(int customerById,Customer cus)
	{
		boolean flag = false;
		if(cus!=null)
		{
			tmap.put(customerById, cus);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateCustomer(int customerId, String mail) throws CustomerNotFoundException
	{
		boolean flag = false;
		try {
			if(!tmap.containsKey(customerId))
			{
				throw new CustomerNotFoundException();
			}
			else
			{
				tmap.get(customerId).setMailId(mail);;
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
			if(!tmap.containsKey(customerId))
			{
				throw new CustomerNotFoundException();
			}
			else
			{
				tmap.remove(customerId);
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
		return tmap;
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException
	{
		Customer cs = null;
		if(!tmap.containsKey(customerId))
		{
			throw new CustomerNotFoundException();
		}
		else
		{
			cs = tmap.get(customerId);
		}
		return cs;
	}
}
