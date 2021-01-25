package com.training.day2;

public class HierarchicalInheritance  //HierarchicalInheritance
{
	public static void main(String[] args)
	{
		Student s1 = new Student();
		s1.PersonalDetails();
		System.out.println();
		s1.StudentInfo();

		System.out.println();

		Employee e1 = new Employee();
		e1.PersonalDetails();
		System.out.println();
		e1.employeeInfo();
	}
}
class Person
{
	void PersonalDetails()
	{
		String name = "Vijeyakumar";
		int age = 22 ;
		String location ="Chennai";
		System.out.println(" Name: "+name +"\n Age: "+age +"\n Current Location: "+ location);
	}
}
class Student extends Person
{
	void StudentInfo()
	{ 
		String collegeName ="Prist University";
		String degree = "B.tech/CSE";
		int yop = 2019;
		int regNo = 2334;
		System.out.println("College Name: "+collegeName +"\n Degree/Stream: "+degree +"\n Year of Passing: "+ yop+"\n Register No: "+regNo);
	}
}
class Employee extends Person
{
	void employeeInfo()
	{       
		String companyName = "HTC Global Services";
		int empId = 25466;
		String designation = "Programmer Analyst";
		System.out.println("Company Name: "+companyName +"\n EmpId: "+empId+"\n Designation :"+designation);
	}
}

