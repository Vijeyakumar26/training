package com.htc.map.dao;

import java.util.Map;
import java.util.Map.Entry;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.map.entity.Customer;

public interface CustomerDAO
{
	public boolean addCustomer(int customerId,Customer cus);
	public boolean updateCustomer(int customerId,String mail)throws CustomerNotFoundException;
	public boolean deleteCustomer(int customerId)throws CustomerNotFoundException;
	public Map <Integer,Customer> getAllCustomers();
	public Customer getCustomerById(int customerId)throws CustomerNotFoundException; 
}
