package com.htc.main;

import java.io.IOException;
import java.sql.SQLException;

import com.htc.connection.DBConnection;
import com.htc.dto.CustomerDTOImpl;
import com.htc.entity.Customer;

public class MainClass
{
	public static void main(String[] args) 
	{
		try 
		{
			DBConnection dbconnect = new DBConnection();
			CustomerDTOImpl obj = new CustomerDTOImpl(dbconnect);
			
			Customer cus1 = new Customer(4,"anu",45645,"Savings",5000.00,"fdjh@htcindia",987456321);
			Customer cus2 = new Customer(8,"anitha",45695,"Savings",15000.00,"fdjh@htcindia",987456322);
			Customer cus3 = new Customer(2,"narmadha",45845,"Savings",25000.00,"fdjh@htcindia",987455322);
		
			
//			obj.insertCustomer(cus1); 
//			obj.insertCustomer(cus2);
//			obj.insertCustomer(cus3);
//			 
//			obj.deleteCustomer(1);
//			obj.deleteCustomer(4);
//			obj.deleteCustomer(2);
//			
//			obj.updateCustomer(5, 7000);
//			
//			obj.deleteCustomer(1);
			
			System.out.println(obj.getCustomerById(8));
			
			System.out.println(obj.getAllCustomers());
		} 
		catch (SQLException | IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}

	}
}
