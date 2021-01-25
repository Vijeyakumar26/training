package com.training.day3;

import java.util.Scanner;

/* b) Create a class IPValidator , encapsulate the method you have created  in question no 5 and test it 
	(try with and without static methods )
 */

public class IPValidationW
{
	public static void main(String[] args)
	{
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter IP Address");
		String ipAddress = scr.next();
		
		IPValidationW obj1 = new IPValidationW();
		
		boolean var = obj1.validateIP(ipAddress);
		if(var)
		{
			System.out.println("Valid IP Address");
		}
		else
		{
			System.out.println("InValid IP Address");
		}
	}
	 boolean validateIP(String ipAddress)
	{
		boolean flag = true;
		int	dotCount = 0;
		boolean isDot = true; 
		boolean	charCheck = true;

		for(int i=0;i<ipAddress.length();i++)
		{

			//checks dot Count
			if(ipAddress.charAt(i) == '.')
			{
				dotCount++;
				//checks Consecutive dots 
				if(ipAddress.charAt(i-1)=='.')
				{
					flag = false;
					break;
				}
			}
			//checks alphabets 
			if((int)ipAddress.charAt(i)<46 || ((int)ipAddress.charAt(i)>57))
			{
				flag = false;
				break;
			}
		}
		//checks length 
		if((ipAddress.length() >= 7) && (ipAddress.length() <= 15))
		{
			//checks dot in begin/end
			if((!ipAddress.startsWith(".")) && (!ipAddress.endsWith(".")))
			{
				if(dotCount == 3)
				{
					flag = true;
				}
				else 
				{
					flag = false;
				}
			}
			else 
			{
				flag = false;
			}
		}
		else 
		{
			flag = false;
		}
		return flag;
	}
}
