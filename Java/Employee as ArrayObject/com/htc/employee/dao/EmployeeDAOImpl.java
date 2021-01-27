package com.htc.employee.dao;

import com.htc.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO
{

	Employee[] eobj = new Employee[5];

	@Override
	public void addEmployee() 
	{
		eobj[0]=new Employee("25466","Vijey","12/12/2004","chennai","vijeyakumar@htcindia.com");
		eobj[1]=new Employee("25467","DJ","1/6/2004","chennai","dhananjeyan@htcindia.com");
		eobj[2]=new Employee("25468","Gokul","12/2/2002","chennai","gokulg@htcindia.com");
		eobj[3]=new Employee("25469","Solomon","5/6/2003","chennai","solomon@htcindia.com");
		eobj[4]=new Employee("25470","Deva","2/1/2004","chennai","Devaanadhan@htcindia.com");
	}

	@Override
	public void updateEmployee(String empid) 
	{
		for(int i=0; i<eobj.length ;i++)
		{
			if(eobj[i].getEmpid().equals(empid))
			{
				eobj[i] = new Employee(empid, "Vijeyakumar", "26/05/1998", "Chennai", "vijeyakumar@htcindia.com");
			}
		}
	}

	@Override
	public void deleteEmployee(String empid) 
	{
		for(int i=0; i<eobj.length ;i++)
		{
			if(eobj[i].getEmpid().equals(empid))
			{
				eobj[i] = new Employee(null, null, null, null, null);
			}
		}
	}

	@Override
	public void getAllEmployees()
	{
		for(Employee obj:eobj)
		{
			System.out.println(obj.getEmpid()+": :"+obj.getEmpName()+": :"+obj.getDob()+": :"+obj.getEmail()+": :"+obj.getAddress());
		}
	}

	@Override
	public void getEmployeeById(String empid)
	{
		for(int i=0; i<eobj.length ;i++)
		{
			if(eobj[i].getEmpid().equals(empid))
			{
				System.out.println(eobj[i].getEmpid()+" "+eobj[i].getEmpName()+" "+eobj[i].getDob()+" "+eobj[i].getEmail()+" "+eobj[i].getAddress());
			}
		}
	}
}
