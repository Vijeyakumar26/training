package com.training.day4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ArraySum
{
	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger(ArraySum.class.getName());
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter array of Numbers");
		int arr[] = new int[5];
		//loop for input
		for(int i = 0; i<arr.length;i++)
		{
			arr[i]=scn.nextInt();
		}
		int sum = 0; 
		//loop for adding
		for(int i = 0; i<arr.length;i++)
		{
			sum = sum + arr[i];
			try 
			{
				LogManager.getLogManager().readConfiguration(new FileInputStream("mylogging.properties"));
				logger.setLevel(Level.FINE);
				logger.addHandler(new ConsoleHandler());
			} 
			catch (SecurityException | IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(sum);
	}
}
