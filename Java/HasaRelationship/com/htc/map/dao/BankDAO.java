package com.htc.map.dao;

import java.util.List;
import java.util.Map;

import com.htc.customer.exception.CustomerNotFoundException;
import com.htc.customer.exception.InSufficientAmountException;
import com.htc.map.entity.BankMap;
import com.htc.map.entity.CustomerMap;

public interface BankDAO 
{
//	public boolean addCustomer(BankMap cb);
//	public boolean updateCustomer(int customerid,double amount) throws CustomerNotFoundException;
//	public boolean deleteCustomer(int customerid) throws CustomerNotFoundException;
//	public BankMap getCustomerById(int customerid) throws CustomerNotFoundException;
//	public List<BankMap> getAllCustomer();
//	public boolean withdrawAmount(int customerid,double amount)throws CustomerNotFoundException,InSufficientAmountException;
	
	public boolean addEmployee(BankMap b);
	public Map<String, List<CustomerMap>> getAllEmpInThisDept();
}
