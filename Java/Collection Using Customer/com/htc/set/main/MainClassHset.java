package com.htc.set.main;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.set.dao.CustomerDAOImplHSet;
import com.htc.set.entity.Customer;

public class MainClassHset
{
	public static void main(String[] args)
	{
		Customer emp1 = new Customer(1,"anu",45645,"Savings",5000.00,"fdjh@htcindia",987456321);
		Customer emp2 = new Customer(5,"anitha",45695,"Savings",15000.00,"fdjh@htcindia",987456322);
		Customer emp3 = new Customer(2,"narmadha",45845,"Savings",25000.00,"fdjh@htcindia",987455322);
		
		CustomerDAOImplHSet obj = new CustomerDAOImplHSet();
		
		obj.addCustomer(emp1);
		obj.addCustomer(emp2);
		obj.addCustomer(emp3);
		
		System.out.println(obj.getAllCustomers());
		
		System.out.println();
		
		try 
		{
			obj.updateCustomer(2, "madurai@htcindia.com");
			System.out.println();
			System.out.println(obj.getCustomerById(2));
			System.out.println();
			obj.deleteCustomer(7);
			System.out.println(obj.getAllCustomers());
			
		} 
		catch (CustomerNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
