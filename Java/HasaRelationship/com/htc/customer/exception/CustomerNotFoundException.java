package com.htc.customer.exception;

public class CustomerNotFoundException extends Exception 
{
	public CustomerNotFoundException() 
	{
		System.err.print("Customer Not Found");
	}
	public CustomerNotFoundException(String msg)
	{
		System.out.println(msg);
	}
}
