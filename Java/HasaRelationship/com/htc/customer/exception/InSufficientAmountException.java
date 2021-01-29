package com.htc.customer.exception;

public class InSufficientAmountException extends Exception
{
	public InSufficientAmountException() 
	{
		System.err.print("Insufficient Balance"+" ");
	}
	public InSufficientAmountException(String msg)
	{
		System.out.println(msg);
	}
}	
