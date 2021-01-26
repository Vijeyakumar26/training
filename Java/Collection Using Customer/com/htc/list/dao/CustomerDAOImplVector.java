package com.htc.list.dao;

import java.util.List;   //Vector
import java.util.Vector;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.list.entity.Customer;

public class CustomerDAOImplVector implements CustomerDAO
{
	List<Customer> vect = new Vector<Customer>();

	@Override
	public boolean addCustomer(Customer cus)
	{
		boolean flag = false;
		if(cus!=null)
		{
			vect.add(cus);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateCustomer(int customerId, String mail)  throws CustomerNotFoundException
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
	public boolean deleteCustomer(int customerId) throws CustomerNotFoundException
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
				vect.remove(cs);
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
	public List<Customer> getAllCustomers() 
	{
		return vect;
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException
	{
		Customer cs = null;
		for(Customer e:vect)
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
