package com.htc.set.main;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.set.dao.CustomerDAOImplTSet;
import com.htc.set.entity.Customer;

public class MainClassTset 
{
	public static void main(String[] args) 
	{
		Customer emp1 = new Customer(1,"anu",11554,"Savings",5000.00,"fdjh@htcindia",987456321);
		Customer emp2 = new Customer(5,"anitha",11555,"Current",15000.00,"abcd@htcindia",987456322);
		Customer emp3 = new Customer(2,"narmadha",11556,"Curr",25000.00,"fgh@htcindia",987456323);
		
		CustomerDAOImplTSet obj = new CustomerDAOImplTSet();
		
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
			
			obj.deleteCustomer(8);
			System.out.println(obj.getAllCustomers());
		} 
		catch (CustomerNotFoundException e)
		{
			e.printStackTrace();
		}

	}
}
