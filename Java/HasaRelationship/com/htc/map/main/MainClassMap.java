package com.htc.map.main;

import java.util.ArrayList;
import java.util.List;


import com.htc.map.dao.BankDAOImpl;
import com.htc.map.entity.BankMap;
import com.htc.map.entity.CustomerMap;

public class MainClassMap
{
	public static void main(String[] args)
	{
		CustomerMap emp1 = new CustomerMap(1,"anu",45645,"Savings",5000.00,"fdjh@htcindia",987456321);
		CustomerMap emp2 = new CustomerMap(5,"anitha",45695,"Savings",15000.00,"fdjh@htcindia",987456322);
		CustomerMap emp3 = new CustomerMap(2,"narmadha",45845,"Savings",25000.00,"fdjh@htcindia",987455322);
		
		List<CustomerMap> emplist = new ArrayList<CustomerMap>();
		
//		emplist.add(emp1);
//		emplist.add(emp2);
//		emplist.add(emp3);

		BankMap b = null;
		
		BankDAOImpl obj = new BankDAOImpl();
		
		emplist.add(emp1);
		emplist.add(emp2);
		emplist.add(emp3);
		obj.addEmployee(b);
		
		System.out.println(obj.getAllEmpInThisDept());
	}
}
