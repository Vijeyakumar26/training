package com.htc.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import com.htc.spring.beans.Employee;
import com.htc.spring.config.TxConfig;
import com.htc.spring.service.EmployeeService;

public class TxAnnoConfigTest
{
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);

		EmployeeService service = (EmployeeService)context.getBean("employeeService");
		boolean result = service.addEmployee(new Employee(108,"ishore","Trainer", 67000.0));
		System.out.println(result);
		try {
			System.out.println(service.getEmployee(103));
		}
		catch(DataAccessException ex) {
			System.out.println("Employee doesn't exist");
		}

		System.out.println("-------------------------------------------------------------");

		for(Employee emp : service.getEmployees()) {
			System.out.println(emp);
		}
	}
}
