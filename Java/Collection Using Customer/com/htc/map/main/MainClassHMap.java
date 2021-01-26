package com.htc.map.main;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.map.dao.CustomerDAOImplHMap;
import com.htc.map.entity.Customer;

public class MainClassHMap
{
	public static void main(String[] args) 
	{
		Customer emp1 = new Customer(1,"anu",45645,"Savings",5000.00,"fdjh@htcindia",987456321);
		Customer emp2 = new Customer(5,"anitha",45695,"Savings",15000.00,"fdjh@htcindia",987456322);
		Customer emp3 = new Customer(2,"narmadha",45845,"Savings",25000.00,"fdjh@htcindia",987455322);
		
		CustomerDAOImplHMap obj = new CustomerDAOImplHMap();
		
		obj.addCustomer(emp1.getCustomerId(),emp1);
		obj.addCustomer(emp2.getCustomerId(),emp2);
		obj.addCustomer(emp3.getCustomerId(),emp3);
		
		System.out.println(obj.getAllCustomers());
		System.out.println();
		
		try 
		{
			obj.updateCustomer(2, "madurai@htcindia.com");
			System.out.println();
			System.out.println(obj.getCustomerById(5));
			System.out.println();
			obj.deleteCustomer(5);
			System.out.println(obj.getAllCustomers());
			
		} 
		catch (CustomerNotFoundException e)
		{
			System.out.println(e);
		}

	}
}
