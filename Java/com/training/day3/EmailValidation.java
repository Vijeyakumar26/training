package com.training.day3;

import java.util.Scanner;

/*
 * 3.  Write a function validate_Email to validate the customers email ID which satisfy the below conditions
Boolean validate Email (String email) {
}
a) Email id should not start with '.' and '@' 
b) Email id should end with either 'm' or 'n' 
c) Email id should have '@' only once
d) Length should be minimum 10 maximum 30 
 */
public class EmailValidation // abcdefghijk@sdm
{
	public static void main(String[] args) 
	{
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter Mail Id");
		String email = scr.nextLine();

		boolean mail = validateEmail(email);//methodcall 

		if(mail)
		{
			System.out.println("Valid Email");
		}
		else
		{
			System.out.println("Invalid Email");
		}
	}

	static boolean validateEmail(String email)
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
