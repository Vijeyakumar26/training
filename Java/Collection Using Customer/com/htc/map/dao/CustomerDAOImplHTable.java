package com.htc.map.dao;

import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.map.entity.Customer;

public class CustomerDAOImplHTable implements CustomerDAO
{
	Map<Integer,Customer> htable = new Hashtable<Integer,Customer>();

	@Override
	public boolean addCustomer(int customerById,Customer cus) 
	{
		boolean flag = false;
		if(cus!=null)
		{
			htable.put(customerById, cus);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateCustomer(int customerId, String mail) throws CustomerNotFoundException
	{
		boolean flag = false;
		
		try {
			if(!htable.containsKey(customerId))
			{
				throw new CustomerNotFoundException();
			}
			else
			{
				htable.get(customerId).setMailId(mail);;
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
			if(!htable.containsKey(customerId))
			{
				throw new CustomerNotFoundException();
			}
			else
			{
				htable.remove(customerId);
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
		return htable;
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException 
	{
		Customer cus = null;
		if(!htable.containsKey(customerId))
		{
			throw new CustomerNotFoundException();
		}
		else
		{
			cus = htable.get(customerId);
		}
		return cus;
	}

}
