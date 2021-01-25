package com.training.day4;

public class ArrayIndexSeperation //7th
{

	public static void main(String[] args) 
	{
		int[] arr = {10,20,30,40,50,60};
		int[] newArray1 = new int[arr.length/2];
		int[] newArray2 = new int[arr.length/2];
		int oddIndex = 0;
		int evenIndex = 0;
		for(int i=0; i<arr.length; i++)
		{
			if(i%2==0)
			{
				newArray1[evenIndex] = arr[i];
				evenIndex++;
			}
			else
			{
				newArray2[oddIndex] = arr[i];
				oddIndex++;
			}

		}
		for(int i = 0; i<newArray1.length;i++)
		{
			System.out.print(newArray1[i]+" ");			
		}
		System.out.println();
		for(int i = 0; i<newArray2.length;i++)
		{
			System.out.print(newArray2[i]+" ");			
		}
	}
}
