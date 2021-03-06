package com.htc.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface="com.htc.webservice.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService
{
	List<Employee> emps = new ArrayList<Employee>();

	public EmployeeServiceImpl() {
		emps.add(new Employee("100", "Gokul", "35","7","8"));
		emps.add(new Employee("101", "Dhananjeyan", "30","7","8"));
		emps.add(new Employee("102", "Deva", "23","5","5"));
		
	}
	
	@Override
	public Employee getEmployee(String employeeId) 
	{
		Employee emp = null;
		for(Employee tp: emps) 
		{
			if(tp.getEmployeeId().equals(employeeId)) 
			{
				emp = tp;
				break;
			}
		}
		return emp;
	}

	@Override
	public boolean addNewEmployee(Employee emp)
	{
		boolean added = false;
		emps.add(new Employee(emp.getEmployeeId(), emp.getEmployeeName(),emp.getTestMarks() ,emp.getInterviewMarks(),emp.getSoftSkillMarks()));		
		return added;
	}

	@Override
	public List<Employee> getEligibleEmp(String testMarks, String interviewMarks, String softSkillMarks) 
	{
		List<Employee> emplist = new ArrayList<Employee>();
		for(Employee tp : emps) 
		{
			if(tp.getTestMarks().equals(30) && tp.getInterviewMarks().equals(6) && tp.getSoftSkillMarks().equals(6)) 
			{
				emplist.add(tp);
			}
		}
		return emplist;
	}

}
