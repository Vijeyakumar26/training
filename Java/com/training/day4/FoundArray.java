package com.training.day4;

import java.util.Arrays;

public class FoundArray //9th
{
	public static void main(String[] args) 
	{
		int[] arr = {12, 54, 19, 20, 44, 32, 14, 63, 57, 28};
		int[] keyarr = {20 ,44, 50, 62, 23, 28 ,19 ,57 ,60 ,99};
		int fIndex = 0;
		int nfIndex = 0;
		int[] found = new int[5];
		int[] notFound = new int[5];
	
		for(int i = 0; i<keyarr.length;i++)
		{
			int count = 0;
			for(int j=0; j<arr.length; j++)
			{
				if(keyarr[i]==arr[j])
				{
					found[fIndex]= keyarr[i];
					fIndex++;
					count=1;
					break;
				}	
			}
			if(count==0)
			{
				notFound[nfIndex]= keyarr[i];
				nfIndex++;
			}
		}
		System.out.println(Arrays.toString(found));
		System.out.println(Arrays.toString(notFound));
	}
}
