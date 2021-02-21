package com.htc.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.htc.spring.beans.Employee;
import com.htc.spring.dao.EmployeeDAO;

public class AOPTest
{
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

		EmployeeDAO dao = (EmployeeDAO)context.getBean("employeeDAO");
		/*	boolean result = dao.addEmployee(new Employee(101,"Hari","Trainer", 50000.0));
		System.out.println(result);
		result = dao.addEmployee(new Employee(102,"Mahesh","Trainer", 45000.0));
		System.out.println(result);
		result = dao.addEmployee(new Employee(103,"Sakthi","Trainer", 60000.0));
		System.out.println(result);
		 */	
		try {
			System.out.println(dao.getEmployee(101));
		}
		catch(DataAccessException ex) {
			System.out.println("Employee doesn't exist");
		}

		System.out.println("-------------------------------------------------------------");

		for(Employee emp : dao.getEmployees()) {
			System.out.println(emp);
		}

	}
}
