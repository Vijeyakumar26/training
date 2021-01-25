package com.training.day2;

public class MultipleInheritance 
{
	public static void main(String[] args)
	{
		Employee1 e1 = new Employee1();
		e1.employeedetails();
		System.out.println();
		e1.studentdetails();
		System.out.println();
		e1.personaldetails();
	}
}
class Person1
{
	void personaldetails()
	{
		String name = "Vijeyakumar";
		int age = 22 ;
		String location ="Chennai";
		System.out.println(" Name: "+name +"\n Age: "+age +"\n Current Location: "+ location);
	}
}
class Student1 extends Person1
{
	void studentdetails()
	{ 
		String collegeName ="Prist University";
		String degree = "B.tech/CSE";
		int yop = 2019;
		int regNo = 2334;
		System.out.println("College Name: "+collegeName +"\n Degree/Stream: "+degree +"\n Year of Passing: "+ yop+"\n Register No: "+regNo);
	}
}
class Employee1 extends Student1
{
	void employeedetails()
	{       
		String companyName = "HTC Global Services";
		int empId = 25466;
		String designation = "Programmer Analyst";
		System.out.println("Company Name: "+companyName +"\n EmpId: "+empId+"\n Designation :"+designation);
	}
}
