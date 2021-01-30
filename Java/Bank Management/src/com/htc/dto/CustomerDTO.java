package com.htc.dto;

import java.io.IOException;
import java.sql.SQLException;

import com.htc.entity.Customer;
import com.htc.entity.Transaction;

public interface CustomerDTO
{
	public void readFileCustomers() throws IOException, SQLException, ClassNotFoundException;
//	public boolean insertToDb(Customer obj) throws IOException, SQLException, ClassNotFoundException;
	public boolean addtransaction(Transaction t);
	public void unloadTrans() throws IOException;
}
