package com.training.day3;

import java.util.Scanner;

/* 5.Write a function validateIPaddress that accepts an ipAddress (string) as an input and does the following validations

(a) Length should be minimum 7 and maximum 15
(b) Should not start and end with dot
(c) Should have exactly 3 dots
(d) Dots should not be in consecutive positions.
(e) Should not permit alphabets and special characters*/

public class IPValidation //000.35.37.19  //qww.yui.poi.lok //123.121.112.345
{
	public static void main(String[] args)
	{
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter IP Address");
		String ipAddress = scr.next();

		boolean var = validateIP(ipAddress);
		if(var)
		{
			System.out.println("Valid IP Address");
		}
		else
		{
			System.out.println("InValid IP Address");
		}
	}

	static boolean validateIP(String ipAddress)
	{
		boolean flag = true;
		int	dotCount = 0;
		boolean isDot = true; 
		boolean	charCheck = true;

		for(int i=0;i<ipAddress.length()-1;i++)
		{

			//checks dot Count
			if(ipAddress.charAt(i) == '.')
			{
				dotCount++;
				//checks Consecutive dots 
				if(ipAddress.charAt(ipAddress.length()-1)=='.')
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
