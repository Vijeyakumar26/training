package com.htc.list.dao;

import java.util.List;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.list.entity.Customer;

public interface CustomerDAO 
{
	public boolean addCustomer(Customer cus);
	public boolean updateCustomer(int customerId,String mail)throws CustomerNotFoundException;
	public boolean deleteCustomer(int customerId)throws CustomerNotFoundException;
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int customerId)throws CustomerNotFoundException; 
}
