package com.htc.customer.dao;

import java.util.ArrayList;
import java.util.List;

import com.htc.customer.entity.Bank;
import com.htc.customer.entity.Customer;
import com.htc.customer.exception.CustomerNotFoundException;
import com.htc.customer.exception.InSufficientAmountException;

public class CustomerDAOImpl implements CustomerDAO
{
	ArrayList<Bank> bank = new ArrayList<Bank>();

	@Override
	public boolean addCustomer(String bankid, String bankname, ArrayList<Customer> cust) 
	{
		Bank b = new Bank(cust,bankname,bankid);
		bank.add(b);
		return true;
	}

	@Override
	public boolean updateCustomer(int customerid, double amount) throws CustomerNotFoundException 
	{
		boolean flag = false;
		Customer cus = getCustomerById(customerid);
		try
		{
			if(cus==null)
				throw new CustomerNotFoundException(); 
			else
			{
				cus.setAccountBalance(amount);
				flag = true;
			}
		}
		catch(CustomerNotFoundException e)
		{
			System.out.println(e);
		}

		return flag;
	}

	@Override
	public boolean deleteCustomer(int customerid) throws CustomerNotFoundException
	{
		boolean flag = false;
		Customer cus = getCustomerById(customerid);
		try 
		{
			if(cus == null)
			{
				throw new CustomerNotFoundException();
			}
			else
			{
				Customer customer;
				Bank bk = null;
				for(Bank b:bank)
				{
					ArrayList <Customer> c = b.getCus();
					customer = c.get(0);
					if(customer == cus) 
					{
						bk = b;
						flag = true;
					}
				}
				if(flag == true) {
					bank.remove(bk);
				}	
			}
		}
		catch (CustomerNotFoundException e) {
			System.out.println(e);
		}
		return flag;
	}

	@Override
	public Customer getCustomerById(int customerid) throws CustomerNotFoundException 
	{
		Customer cus  = null;
		Customer customer;
		int index = 0;
		for(Bank b:bank) 
		{
			ArrayList<Customer> c = b.getCus();
			customer = c.get(index);
			if(customer.getCustomerId()==customerid)
			{
				cus = customer;
				index++;
			}
		}
//		if(cus==null)
//			throw new CustomerNotFoundException();
		return cus;
	}

	@Override
	public ArrayList<Bank> getAllCustomer() 
	{
		return bank;
	}

	@Override
	public boolean withdrawAmount(int customerid, double amount)
			throws CustomerNotFoundException, InSufficientAmountException 
	{
		Customer cus = getCustomerById(customerid);
		double balance = cus.getAccountBalance();

		System.out.println("Available Balance = "+balance);
		System.out.println("Withdraw = "+amount);

		if(amount>balance)
			throw new InSufficientAmountException();
		else
			balance = balance - amount;
		System.out.println("Remaining Balance "+balance);
		updateCustomer(customerid, balance);
		System.out.println(getCustomerById(customerid));

		return true;
	}
}
