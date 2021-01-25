package com.training.day4;

import java.util.Arrays;

public class ReverseArray 
{
	public static void main(String[] args) 
	{
		int arr[]= {10,20,30,40,50};
		int arr1[]= new int[arr.length];
		int num = 0;
		for(int i=arr.length-1;i>=0;i--)
		{
			//System.out.println(elements1[i]);
			arr1[num] = arr[i];
			num++;
		}

		for(int i = 0; i<arr1.length; i++)
		{
			System.out.print(arr1[i]+" ");
		}
	}
}
