package com.htc.set.dao;

import java.util.Set;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.set.entity.Customer;

public interface CustomerDAO  //Customer Set DAO
{
	public boolean addCustomer(Customer cus);
	public boolean updateCustomer(int customerId,String mail)throws CustomerNotFoundException;
	public boolean deleteCustomer(int customerId)throws CustomerNotFoundException;
	public Set<Customer> getAllCustomers();
	public Customer getCustomerById(int customerId)throws CustomerNotFoundException; 
}
