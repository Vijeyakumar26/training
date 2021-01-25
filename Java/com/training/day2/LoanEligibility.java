package com.training.day2;

import java.util.Scanner;
/*
 * Implement the following logic to arrive at the loan eligibility for an employee: (Do not use logical operator)

(a) For an Unmarried permanent job holder, if the service has been for 30 years or more, 
	the loan amount is Rs.50,000; otherwise the loan amount is Rs.25,000

(b) For a married permanent job holder, if the service has been for 30 years or more,
	the loan amount is Rs.60,000; otherwise the loan amount is Rs.35,000

(c) For temporary job holder, the loan amount is Rs.10,000
 */
public class LoanEligibility 
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		
		System.out.println("Enter MartialStatus :"); 
		String martialStatus=in.nextLine(); 		//checks Married or Unmarried
		
		System.out.println("Enter jobStatus :");		//checks Permanent or Temporary
		String jobStatus=in.nextLine();
		
		System.out.println("Enter Experience :");		////checks Permanent or Temporary
		int experience=in.nextInt();

		int loanAmount;
		if(martialStatus.equalsIgnoreCase("unmarried"))
		{
			if(jobStatus.equalsIgnoreCase("permanent")) 
			{
				if(experience>=30) 
				{
					loanAmount= 50000;
					System.out.println("loan amount = "+loanAmount);	
				}
				else
				{
					loanAmount = 25000;
					System.out.println("loan amount = "+loanAmount);
				}
			}
		}  
		
		if(martialStatus.equalsIgnoreCase("married"))
		{
			if(jobStatus.equalsIgnoreCase("permanent"))
			{
				if(experience>=30) 
				{
					loanAmount= 60000;
					System.out.println("loan amount = "+loanAmount);
				}
				else
				{
					loanAmount=35000;
					System.out.println("loan amount = "+loanAmount);					
				}
			}
		}  
		if (jobStatus.equalsIgnoreCase("temporary"))
		{
			loanAmount =10000;
			System.out.println("loan amount = "+loanAmount);
		}
	}
}
