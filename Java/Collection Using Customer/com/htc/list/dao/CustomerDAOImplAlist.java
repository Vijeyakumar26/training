package com.htc.list.dao;

import java.util.ArrayList;	//ArrayList
import java.util.List;
import java.util.logging.Logger;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.list.entity.Customer;
import com.htc.list.main.MainClassAlist;

public class CustomerDAOImplAlist implements CustomerDAO
{
	Logger logger = Logger.getLogger(MainClassAlist.class.getName());
	
	List<Customer> alist = new ArrayList<Customer>();

	@Override
	public boolean addCustomer(Customer cus) 
	{
		boolean flag = false;
		if(cus!=null)
		{
			alist.add(cus);
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
				logger.severe("Customer Not Found for updating");
				throw new CustomerNotFoundException();
			}
			else
			{
				cs.setMailId(mail);
				flag = true;
				logger.info("Customer Mail Updated");
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
				logger.severe("Customer Not Found for deleting");
				throw new CustomerNotFoundException();
			}
			else
			{
				alist.remove(cs);
				flag = true;
				logger.info("Customer deleted");
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
		return alist;
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException
	{
		Customer cs = null;
		for(Customer e:alist)
		{
			if(e.getCustomerId()==customerId)
			{
				cs = e;
				logger.info("Customer Found");
			}
		}
		if(cs==null)
		{
			logger.severe("Customer Not Found");
			throw new CustomerNotFoundException();
		}
		return cs;
	}

}
