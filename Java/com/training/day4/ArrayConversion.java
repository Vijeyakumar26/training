package com.training.day4;

public class ArrayConversion //6th
{
	public static void main(String[] args)
	{
		int[] arr = {12, 54, 26 ,85};// 21 45 62 58
		int temp1;
		int temp2 ;
		for(int i=0; i<arr.length; i++)
		{
			temp1 = arr[i]%10;
			arr[i]= arr[i]/10;
			temp2 = arr[i]%10;
			arr[i] = 0;
			arr[i]= temp1*10+temp2;
			System.out.print(arr[i] + " ");
		}
	}
}

