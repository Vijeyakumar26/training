package com.htc.main;

import java.util.Arrays;

import com.htc.entity.Employee;
import com.htc.entity.EmployeeComparator;

public class MainComparator 
{
	public static void main(String[] args)
	{
		EmployeeComparator[] empArr = new EmployeeComparator[4];
		empArr[0] = new EmployeeComparator(10, "Mikey", 25, 10000);
		empArr[1] = new EmployeeComparator(20, "Arun", 29, 20000);
		empArr[2] = new EmployeeComparator(5, "Lisa", 35, 5000);
		
		Arrays.sort(empArr, EmployeeComparator.SalaryComparator);
		System.out.println("Employees list sorted by Salary:\n"+Arrays.toString(empArr));

		//sort employees array using Comparator by Age
		Arrays.sort(empArr, EmployeeComparator.AgeComparator);
		System.out.println("Employees list sorted by Age:\n"+Arrays.toString(empArr));

		//sort employees array using Comparator by Name
		Arrays.sort(empArr, EmployeeComparator.NameComparator);
		System.out.println("Employees list sorted by Name:\n"+Arrays.toString(empArr));
	}
}
