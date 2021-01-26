package com.htc.set.dao;

import java.util.Set;
import java.util.TreeSet;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.set.entity.Customer;

public class CustomerDAOImplTSet implements CustomerDAO
{
	Set<Customer> tset = new TreeSet<Customer>();

	@Override
	public boolean addCustomer(Customer cus) {
		boolean flag = false;
		if(cus!=null)
		{
			tset.add(cus);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateCustomer(int customerId, String mail) throws CustomerNotFoundException {
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
				tset.remove(cs);
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
		return tset;
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		Customer cs = null;
		for(Customer e:tset)
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
