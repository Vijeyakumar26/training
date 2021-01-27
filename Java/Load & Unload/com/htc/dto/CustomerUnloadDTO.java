package com.htc.dto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.htc.entity.Customer;

public interface CustomerUnloadDTO
{
	//to read all record of employee table
	public List<Customer> getAllCustomers() throws SQLException;
	
	//to write employee record into excel
	public boolean unloadCustomerDetail(List<Customer> cus) throws IOException;
}
