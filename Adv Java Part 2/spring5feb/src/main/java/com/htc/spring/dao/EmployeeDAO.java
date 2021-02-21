package com.htc.spring.dao;

import java.util.List;

import com.htc.spring.beans.Employee;

public interface EmployeeDAO
{
	public boolean addEmployee(Employee emp);
	public boolean addEmployee(int empno, String ename, String job, double salary);
	public Employee getEmployee(int empno);
	public List<Employee> getEmployees();
	public boolean deleteEmployee(int empno);
	public boolean updateEmployee(int empno,double sal);
}
