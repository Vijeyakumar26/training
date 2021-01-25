package com.training.day4;

public class ArrayElementCount //10
{
	public static void main(String[] args) 
	{
		int[] arr = {12 ,54, 19, 20, 44, 19, 14, 54, 20, 19};
		int[] keyarr = {12 ,54, 44, 20, 19};

		int index=0;
		int found[]=new int [5];
		
		for(int i=0;i<keyarr.length;i++)
		{
			int count=0;
			for(int j=0;j<arr.length;j++)
			{
				if(keyarr[i]==arr[j])
				{
					count = count + 1;
				}
			}
			if(count>=1)
			{
				found[index]=count;
				index++;
			}
		}
		for(int i= 0 ; i<found.length;i++)
		{
			System.out.print(found[i]+" ");
		}
	}
}
