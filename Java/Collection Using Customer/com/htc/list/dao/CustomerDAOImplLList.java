package com.htc.list.dao;

import java.util.LinkedList; //Linkedlist
import java.util.List;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.list.entity.Customer;

public class CustomerDAOImplLList implements CustomerDAO
{
	List<Customer> llist = new LinkedList<Customer>();

	@Override
	public boolean addCustomer(Customer cus) 
	{
		boolean flag = false;
		if(cus!=null)
		{
			llist.add(cus);
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
	public boolean deleteCustomer(int customerId)throws CustomerNotFoundException
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
				llist.remove(cs);
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
		return llist;
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException
	{
		Customer cs = null;
		for(Customer e:llist)
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
