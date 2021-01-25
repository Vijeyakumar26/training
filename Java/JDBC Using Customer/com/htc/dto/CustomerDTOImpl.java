package com.htc.dto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htc.connection.DBConnection;
import com.htc.entity.Customer;

public class CustomerDTOImpl implements CustomerDTO
{
	DBConnection dbconnect = new DBConnection();
	
	Connection con;
	
	List<Customer> emplist = new ArrayList<Customer>();
	
	public CustomerDTOImpl(DBConnection dbconnect) throws ClassNotFoundException, IOException, SQLException 
	{
		super();
		this.dbconnect = dbconnect;
		this.con = dbconnect.getConnection();
	}

	@Override
	public boolean insertCustomer(Customer cus) throws SQLException 
	{
		if(cus!=null)
		{			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO CUSTOMERS "
					+ "(customerId,customerName,accountno,accountType,balance,mailId,contactNo) VALUES(?,?,?,?,?,?,?)");
			
			stmt.setInt(1, cus.getCustomerId());
			stmt.setString(2, cus.getCustomerName());
			stmt.setInt(3, cus.getAccountNo());
			stmt.setString(4, cus.getAccountType());
			stmt.setDouble(5, cus.getAccountBalance());
			stmt.setString(6, cus.getMailId());
			stmt.setInt(7, cus.getContactNo());
			
			int count = stmt.executeUpdate();
			if(count>0)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateCustomer(int customerId, double accountBalance) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement("UPDATE customers SET balance=? WHERE customerId=?");
		stmt.setDouble(1, accountBalance);
		stmt.setInt(2, customerId);
		stmt.execute();
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerId) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement("DELETE FROM customers WHERE customerId = ?");
		stmt.setInt(1, customerId);
		stmt.execute();
		return true;
	}

	@Override
	public List<Customer> getAllCustomers() throws SQLException
	{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT customerId,customerName,accountno,accountType,balance,mailId,contactNo FROM CUSTOMERS;");
		while(rs.next())
		{
			emplist.add(new Customer(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7)));
		}
		return emplist;
	}

	@Override
	public Customer getCustomerById(int customerId) throws SQLException
	{
		Customer emp = null;
		ResultSet rs = null;
		PreparedStatement stmt = con.prepareStatement("SELECT customerId,customerName,accountno,accountType,balance,mailId,contactNo FROM CUSTOMERS where customerId=?");
		stmt.setInt(1,customerId);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			emp =(new Customer(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7)));
		}
		
		return emp;
	}
}
