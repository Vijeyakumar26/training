package com.htc.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.htc.spring.beans.Employee;
import com.htc.spring.dao.EmployeeDAO;

public class MainClass 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");

		EmployeeDAO dao = (EmployeeDAO)context.getBean("employeeDAO");
		//		boolean result = dao.addEmployee(new Employee(101,"DJ","SDE", 40000.0));
		//		System.out.println(result);
		//		result = dao.addEmployee(new Employee(102,"Gokul","QA", 45000.0));
		//		System.out.println(result);
		//		result = dao.addEmployee(new Employee(103,"VJ","SDE", 40000.0));
		//		System.out.println(result);
//
//		try
//		{
//			System.out.println("Get Employee");
//			System.out.println(dao.getEmployee(103));
//			System.out.println("-------------------------------------------------------------");
//			System.out.println("Delete Employee");
//			System.out.println(dao.deleteEmployee(103));
//		}
//		catch(DataAccessException ex)
//		{
//			System.out.println("Employee doesn't exist");
//		}
//
//		System.out.println("-------------------------------------------------------------");
//		System.out.println("Get All Employees");
//		for(Employee emp : dao.getEmployees()) 
//		{
//			System.out.println(emp);
//		}
//		
//		System.out.println("-------------------------------------------------------------");
//		System.out.println("Delete Employee");
//		System.out.println(dao.deleteEmployee(103));
//		System.out.println("-------------------------------------------------------------");
//		System.out.println("Update Employee");
//		System.out.println(dao.updateEmployee(101,51000));
//		System.out.println("-------------------------------------------------------------");
//		System.out.println("Get All Employees");
//		for(Employee emp : dao.getEmployees()) 
//		{
//			System.out.println(emp);
//		}
		try {
		dao.getEmployee(103);
		}
		catch(DataAccessException ex)
		{
			
		}
		dao.deleteEmployee(103);
		dao.updateEmployee(101,51000);
		for(Employee emp : dao.getEmployees()) 
		{
			System.out.println(emp);
		}
	}

}
