package com.htc.customerException;

public class CustomerNotFoundException extends Exception
{
	public CustomerNotFoundException() 
	{
		System.out.print("Customer Not Found");
	}
	public CustomerNotFoundException(String msg)
	{
		System.out.println(msg);
	}
}