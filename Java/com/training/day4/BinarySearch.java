package com.training.day4;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter length of array: ");

		int length = input.nextInt();
		int array[] = new int[length];

		System.out.println("Enter array of elements: ");
		//loop for accepting input
		for(int i=0;i<array.length;i++)
		{
			array[i] = input.nextInt();
		}

		System.out.println(Arrays.toString(array));

		int size_of_array = array.length;
		System.out.println("Enter the search element ");

		int search = input.nextInt();

		int low = 0, high = size_of_array-1;
		while(array[low] <= array[high])
		{
			int mid = (low + high) /2;
			if(array[mid] == search)
			{
				System.out.println("Found ");
				break;
			}
			if(array[mid] < search)
				low = mid + 1;
			else
				high = mid - 1;

		}
	}
}
