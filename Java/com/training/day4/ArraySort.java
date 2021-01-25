package com.training.day4;

public class ArraySort 
{
	public static void main(String[] args) 
	{
		int arr[] = {12 ,54, 26, 85, 21, 45, 62, 58};
		int temp = arr[0];
		int n= arr.length;
		//loop for iterating array
		for(int i =0; i<n; i++)
		{
			//loop to compare array with previous loop
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int i =0; i<n; i++)
		{
			System.out.print(arr[i]+ " ");
		}
	}
}
