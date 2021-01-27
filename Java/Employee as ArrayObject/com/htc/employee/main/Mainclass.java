package com.htc.employee.main;

import com.htc.employee.dao.EmployeeDAOImpl;

public class Mainclass
{
	public static void main(String[] args) throws NullPointerException
	{
		EmployeeDAOImpl obj = new EmployeeDAOImpl();
		
		//add employees
		obj.addEmployee();
		obj.getAllEmployees();
		System.out.println();
		
		//get Employee by Id
		String empid = "25466";
		obj.getEmployeeById(empid);
		System.out.println();
		
		empid = "25467";
		//update employee
		obj.updateEmployee(empid);
		obj.getEmployeeById(empid);
		System.out.println();
		
		//delete employee
		obj.deleteEmployee(empid);
		obj.getAllEmployees();
	}
}
