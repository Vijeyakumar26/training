package com.training.day2;

import java.util.Scanner;

/*
 *  1. Write a Java Program to Display the ATM Transaction. 
The user will choose from any one of the available options as input like withdraw, deposit and check balance.

Case 1: Withdraw
	If the balance amount greater than or equal to the withdrawal amount then Perform the transaction and give the user the desired amount, 
	else print Insufficient Funds message.
Case 2: Deposit
	Add the received input from the user to balance and update its value.
Case 3: Check Balance
	Print a message on screen showing the value of balance amount.
Case 4: Exit
 */

public class ATMTransaction
{
	public static void main(String[] args) 
	{
		Scanner scr = new Scanner(System.in);
		double balance = 5000.0;
		int cond = 0;
		do
		{
			System.out.println(" 1 for Withdraw \n 2 for Deposit \n 3 for Balance Check \n 4 for Exit");
			int option = scr.nextInt();
			switch (option)
			{
			case 1: //Withdraw 
				System.out.println("Enter Amount to withdraw :");
				double amount=scr.nextDouble();

				if(balance>=amount)
				{
					System.out.println("Transaction Successful, Please collect your money");
					balance=balance-amount;
					System.out.println("Balance: "+balance);
				}
				else
					System.out.println("Insufficient Balance, Try again");
				break;

			case 2: //Deposit
				System.out.println("Enter money to Deposited :"); 
				double deposit=scr.nextDouble();
				balance=deposit+balance;
				System.out.println("Deposited successful : "+ balance);
				break;

			case 3://Balance Check
				System.out.println("Balance :"+ balance);
				break;

			case 4: //Exit
				System.out.println("Thank you");
				break;

			default :
				System.out.println("Enter valid option");
			}
			System.out.println("Do you want to continue? \n Y - 1 \n N - 0");
			cond = scr.nextInt();
		}
		while(cond==1);
	}
}



