package com.htc.customerException;

public class InSufficientAmountException extends Exception
{
	public InSufficientAmountException() 
	{
		System.out.print("Insufficient Balance");
	}
	public InSufficientAmountException(String msg)
	{
		System.out.println(msg);
	}
}
