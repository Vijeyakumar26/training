package com.htc.spring.service;

import java.util.List;

import com.htc.spring.beans.Employee;
import com.htc.spring.dao.EmployeeDAO;

public class EmployeeService 
{
	EmployeeDAO empdao;

	public EmployeeDAO getEmpdao() {
		return empdao;
	}
	public void setEmpdao(EmployeeDAO empdao) {
		this.empdao = empdao;
	}

	public boolean addEmployee(Employee emp)
	{
		try 
		{
			return empdao.addEmployee(emp);
			//additional logic
		}
		catch(Exception ex) 
		{
			return false;
		}
	}
	public boolean addEmployee(int empno, String ename, String job, double salary) 
	{
		try 
		{
			return empdao.addEmployee(empno, ename, job, salary);
		}
		catch(Exception ex) 
		{
			return false;
		}
		
	}
	public Employee getEmployee(int empno) {
		return empdao.getEmployee(empno);
	}
	public List<Employee> getEmployees() {
		return empdao.getEmployees();
	}
	public boolean deleteEmployee(int empno) {
		return empdao.deleteEmployee(empno);
	}
	public boolean updateEmployee(int empno,double sal) {
		return empdao.updateEmployee(empno, sal);
	}
}
