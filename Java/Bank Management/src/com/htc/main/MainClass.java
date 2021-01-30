package com.htc.main;

import java.io.IOException;
import java.sql.SQLException;

import com.htc.dto.CustomerDTOImpl;
import com.htc.entity.Transaction;


public class MainClass 
{
	public static void main(String[] args) 
	{
		CustomerDTOImpl cs=new CustomerDTOImpl();

		try 
		{
			cs.readFileCustomers();
			
			
			Transaction t1 = new Transaction(101,10,2000);
			Transaction t2 = new Transaction(102,12,2000000);
			
			cs.addtransaction(t1);
			cs.addtransaction(t2);
			
			cs.unloadTrans();	
		} 
		catch (ClassNotFoundException | IOException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
}
