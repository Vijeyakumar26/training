package com.training.day4;

public class PrimeCountArray
{
	public static void main(String[] args)
	{
		int array[] = {2,3,4,5};
		int flag = 0;
		int num=0;
		int count=0;
		for(int i=0;i<array.length;i++)
		{
			num = array[i];
			if(num==2)
				flag = 0;
			for(int j = 2;j<=num/2;j++)
			{					
				if(num % j == 0)
				{
					flag = 1;
					break;
				}
				flag = 0;
				//break;
			}
			if(flag==0)
				count = count +1;
		}
		System.out.println(count);
	}
}