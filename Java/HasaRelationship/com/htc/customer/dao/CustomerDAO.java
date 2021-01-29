package com.htc.customer.dao;

import java.util.ArrayList;

import com.htc.customer.entity.Bank;
import com.htc.customer.entity.Customer;
import com.htc.customer.exception.CustomerNotFoundException;
import com.htc.customer.exception.InSufficientAmountException;

public interface CustomerDAO 
{
	public boolean addCustomer(String bankid, String bankname, ArrayList<Customer> cust);
	public boolean updateCustomer(int customerid,double amount) throws CustomerNotFoundException;
	public boolean deleteCustomer(int customerid) throws CustomerNotFoundException;
	public Customer getCustomerById(int customerid) throws CustomerNotFoundException;
	public ArrayList<Bank> getAllCustomer();
	public boolean withdrawAmount(int customerid,double amount)throws CustomerNotFoundException,InSufficientAmountException;
}
