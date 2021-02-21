package com.htc.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.htc.spring.beans.Employee;
import com.htc.spring.service.EmployeeService;

public class TxTest 
{
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("tx.xml");

		EmployeeService service = (EmployeeService)context.getBean("employeeService");
//		boolean result = service.addEmployee(new Employee(104,"ishore","Trainer", 67000.0));
//		System.out.println(result);
		try
		{
			System.out.println(service.getEmployee(102));
		}
		catch(DataAccessException ex)
		{
			System.out.println("Employee doesn't exist");
		}

		System.out.println("-------------------------------------------------------------");

		for(Employee emp : service.getEmployees())
		{
			System.out.println(emp);
		}
	}
}	
