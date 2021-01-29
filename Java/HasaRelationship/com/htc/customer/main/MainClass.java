package com.htc.customer.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;

import com.htc.customer.dao.CustomerDAOImpl;
import com.htc.customer.entity.Bank;
import com.htc.customer.entity.Customer;
import com.htc.customer.exception.CustomerNotFoundException;
import com.htc.customer.exception.InSufficientAmountException;

public class MainClass 
{

	public static void main(String[] args)  throws CustomerNotFoundException, InSufficientAmountException
	{
		ArrayList<Customer> customers = new ArrayList<>();
		Customer c1 = new Customer(1,"anu",45645,"Savings",5000.00,"fdjh@htcindia",987456321);
		Customer c2 = new Customer(5,"anitha",45695,"Savings",15000.00,"fdjh@htcindia",987456322);
		Customer c3 = new Customer(2,"narmadha",45845,"Savings",25000.00,"fdjh@htcindia",987455322);
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		
		CustomerDAOImpl obj = new CustomerDAOImpl();
	
	     obj.addCustomer("HDFC01", "HDFC", customers);
	     obj.addCustomer("Axis01", "AXIS", customers);
		
		
		Scanner input = new Scanner(System.in);

		while(true)
		{
			System.out.println(" 1: GetAllCustomer \n 2: GetCustomerbyId \n 3: DeleteCustomer \n 4: UpdateCustomer"
					+ "\n 5: Withdraw \n 6. Exit ");
			int option = input.nextInt();

			switch(option)
			{
			case 1:
				System.out.println(obj.getAllCustomer());
				break;
			case 2:
				//Retrieve by customer id
				try 
				{
					System.out.println(obj.getCustomerById(0));
				} 
				catch(CustomerNotFoundException e)
				{
					System.err.println(e);
				}
				break;
			case 3:
				//Delete by customer id
				try 
				{
					obj.deleteCustomer(1);
				} 
				catch (CustomerNotFoundException e)
				{
					System.out.println(e);
				}
				break;
			case 4:
				//update by customer id
				try
				{
					obj.updateCustomer(5,50000);
				}
				catch (CustomerNotFoundException e)
				{
					System.out.println(e);
				}
				break;
			case 5:
				//withdraw amount
				try
				{
					obj.withdrawAmount(5,17000);
				}
				catch(InSufficientAmountException e) 
				{
					System.out.println(e);
				}
				break;
			default:
				System.exit(0);
			
			}
		}
	}
}
