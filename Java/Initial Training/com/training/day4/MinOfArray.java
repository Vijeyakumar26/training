package com.training.day4;

import java.util.Scanner;

public class MinOfArray//1st
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter array of Numbers");
		int arr[] = new int[5];
		//loop for input
		for(int i = 0; i<arr.length;i++)
		{
			arr[i]=scn.nextInt();
		}
		//assign first array value to variable
		int small = arr[0];
		//loop for finding smallest
		for(int i = 0; i<arr.length;i++)
		{
			if(arr[i]<small)
			{
				small=arr[i];
			}
		}
		System.out.println(small);
	}
}
