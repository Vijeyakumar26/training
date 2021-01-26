package com.htc.set.dao;

import java.util.HashSet;
import java.util.Set;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.set.entity.Customer;

public class CustomerDAOImplHSet implements CustomerDAO
{
	Set<Customer> hset = new HashSet<Customer>();

	@Override
	public boolean addCustomer(Customer cus)
	{
		boolean flag = false;
		if(cus!=null)
		{
			hset.add(cus);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateCustomer(int customerId, String mail) throws CustomerNotFoundException
	{

		boolean flag = false;
		Customer cs = getCustomerById(customerId);
		try {
			if(cs==null)
			{
				throw new CustomerNotFoundException();
			}
			else
			{
				cs.setMailId(mail);
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
	public boolean deleteCustomer(int customerId) throws CustomerNotFoundException {
		boolean flag = false;
		Customer cs = getCustomerById(customerId);
		try {
			if(cs==null)
			{
				throw new CustomerNotFoundException();
			}
			else
			{
				hset.remove(cs);
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
	public Set<Customer> getAllCustomers()
	{
		return hset;
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		Customer cs = null;
		for(Customer e:hset)
		{
			if(e.getCustomerId()==customerId)
			{
				cs = e;
			}
		}
		if(cs==null)
			throw new CustomerNotFoundException();
		return cs;
	}

}
