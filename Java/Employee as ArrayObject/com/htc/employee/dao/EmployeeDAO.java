package com.htc.employee.dao;

public interface EmployeeDAO 
{
	abstract void addEmployee();
	abstract void getAllEmployees();
	abstract void updateEmployee(String empid);
	abstract void deleteEmployee(String empid);
	abstract void getEmployeeById(String empid);
}
