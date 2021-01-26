package com.htc.list.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.htc.customerException.CustomerNotFoundException;
import com.htc.list.dao.CustomerDAOImplAlist;
import com.htc.list.entity.Customer;
//import com.htc.loggers.MyFormatter;

public class MainClassAlist 
{
	public static void main(String[] args)
	{
		Customer emp1 = new Customer(1,"anu",45645,"Savings",5000.00,"fdjh@htcindia",987456321);
		Customer emp2 = new Customer(5,"anitha",45695,"Savings",15000.00,"fdjh@htcindia",987456322);
		Customer emp3 = new Customer(2,"narmadha",45845,"Savings",25000.00,"fdjh@htcindia",987455322);

		CustomerDAOImplAlist obj = new CustomerDAOImplAlist();

		try
		{
			Logger logger = Logger.getLogger(MainClassAlist.class.getName());
			boolean append = true;
//			FileHandler handler = new FileHandler("default.log", append);
			LogManager.getLogManager().readConfiguration(new FileInputStream("mylogging.properties"));
//			logger.addHandler(handler);
			
			Handler fileHandler = new FileHandler("pattern.log",5000, 2);
			fileHandler.setFormatter(new MyFormatter());
			fileHandler.setLevel(Level.ALL);
			logger.addHandler(fileHandler);
			
		}
		catch (SecurityException | IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Scanner input = new Scanner(System.in);
		while(true)
		{
			System.out.println("Choose 1 - Add");
			System.out.println("Choose 2 - Update");
			System.out.println("Choose 3 - View");
			System.out.println("Choose 4 - View BY ID");
			System.out.println("Choose 5 - Delete");
			System.out.println("Choose 6 - Exit");

			int getOption = input.nextInt();

			switch(getOption)
			{
			case 1:
				obj.addCustomer(emp1);
				obj.addCustomer(emp2);
				obj.addCustomer(emp3);
				break;

			case 2:
				try
				{
					obj.updateCustomer(2, "madurai@htcindia.com");
				}
				catch(CustomerNotFoundException e)
				{
					System.out.println(e);
				}
				break;

			case 3:
				System.out.println(obj.getAllCustomers());
				break;

			case 4:
				try
				{
					System.out.println(obj.getCustomerById(2));
				}
				catch(CustomerNotFoundException e)
				{
					System.out.println(e);
				}
				break;

			case 5:
				try
				{
					obj.deleteCustomer(1);
				}
				catch(CustomerNotFoundException e)
				{
					System.out.println(e);
				}
				break;

			case 6:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Input! [Chose 1 to 6]");	        	
			}
		}
	}
}
