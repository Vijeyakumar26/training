package com.htc.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportNumValidation 
{	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your PassportNumber: ");
		String pNum = sc.next();
		boolean check = validatePassport(pNum);
		
		if(check)
		{
			System.out.println("Valid Passport Number");
		} 
		else
		{
			System.out.println("Invalid Passport Number");
		}
	}
	static boolean validatePassport(String mail)
	{
		Pattern pattern = Pattern.compile("^[A-PR-WYa-pr-wy][1-9]\\d" + "\\s?\\d{4}[1-9]$");
		Matcher match = pattern.matcher(mail);
		return match.matches();
	}
}
