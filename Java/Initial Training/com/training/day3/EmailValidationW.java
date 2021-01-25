package com.training.day3;

import java.util.Scanner;

/*8.a) Create a class EmailValidator , encapsulate the method prepared in question no 3 and test it 
	(try with and without static methods ) */
public class EmailValidationW 
{
	public static void main(String[] args) 
	{
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter Mail Id");
		String email = scr.nextLine();

		EmailValidationW obj = new EmailValidationW();

		boolean mail = obj.validateEmail(email);

		if(mail)
		{
			System.out.println("Valid Email");
		}
		else
		{
			System.out.println("Invalid Email");
		}
	}
	boolean validateEmail(String email)
	{
		boolean flag= true;
		int atCount = 0;
		for(int i = 0; i<email.length(); i++)
		{
			//checks count of @
			if(email.charAt(i)=='@') 
			{
				atCount++;
			}
		}
		//checks length
		if(email.length()>=10 && email.length()<=30)
		{
			//checks doesnot starts with @ or .
			if(!email.startsWith(".")||!email.startsWith("@"))
			{
				//checks ends with m or n
				if(email.endsWith("m")||email.endsWith("n"))
				{
					if(atCount==1)
						flag= true;
					else 
						flag=false;
				}
				else 
				{
					flag=false;
				}
			}
			else 
			{
				flag=false;
			}
		}
		else 
		{
			flag=false;
		}
		return flag;
	}
}
