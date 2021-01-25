package com.htc.exception;

public class CustomerNotFoundException extends Exception
{
	String message;
	public CustomerNotFoundException() {
		// TODO Auto-generated constructor stub
		this.message="Given Employee Id is invalid.";
	}
	
	public CustomerNotFoundException( String message){
		this.message= message;
	}

	@Override
	public String toString() {
		return "CustomerNotFoundException [message=" + message + "]";
	}
}
