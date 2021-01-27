package com.htc.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.htc.connection.DBConnection;
import com.htc.dto.CustomerUnloadDTOImpl;
import com.htc.entity.Customer;

public class MainClass
{
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException
	{
		DBConnection dbconnect = new DBConnection();
		CustomerUnloadDTOImpl obj = new CustomerUnloadDTOImpl(dbconnect);
		
		List<Customer> emplist = obj.getAllCustomers();
		
		obj.unloadCustomerDetail(emplist);	
	}
}
