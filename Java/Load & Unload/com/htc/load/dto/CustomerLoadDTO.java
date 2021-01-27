package com.htc.load.dto;

import java.io.IOException;
import java.sql.SQLException;

import com.htc.entity.Customer;

public interface CustomerLoadDTO
{
	public void readFile() throws IOException, SQLException, ClassNotFoundException;
	public boolean insertToDb(Customer obj) throws IOException, SQLException, ClassNotFoundException;
}
