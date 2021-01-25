package com.htc.dto;

import java.sql.SQLException;
import java.util.List;

import com.htc.entity.Customer;

public interface CustomerDTO
{
	public boolean insertCustomer(Customer c) throws SQLException;
	public boolean updateCustomer(int customerId,double accountBalance)throws SQLException;
	public boolean deleteCustomer(int customerId) throws SQLException; 
	public List<Customer> getAllCustomers()throws SQLException;
	public Customer getCustomerById(int customerId) throws SQLException;
}
