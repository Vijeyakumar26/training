package com.htc.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.htc.service.entity.Service;

public class ServiceDAOImpl implements ServiceDAO 
{

	@Override
	public boolean checkServiceId(String serviceId) 
	{
		Connection con = null;
		boolean serviceFound = false;
		try {
			InitialContext context = new InitialContext();  //Entry point to JNDI naming registry
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pgsql");
			con  = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("select count(*) from service where serviceid = ?");
			pst.setString(1, serviceId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1) == 1) {
					serviceFound = true;
				}
			}

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return serviceFound;
	}

	@Override
	public Service getService(String serviceId)
	{
		Connection con = null;
		Service service = null;
		try {
			InitialContext context = new InitialContext();  //Entry point to JNDI naming registry
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pgsql");
			con  = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT serviceid,servicedesc,price,status FROM service where serviceid = ?");
			pst.setString(1, serviceId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				service = new Service(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} 
		catch (NamingException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return service;
	}

	@Override
	public boolean updateService(String serviceId, String serviceDesc, String price, String status) 
	{
		Connection con = null;
		boolean userService = false;
		try {
			InitialContext context = new InitialContext();  //Entry point to JNDI naming registry
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pgsql");
			con  = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("update service set servicedesc=?, price=?, status=?  where serviceid = ?");
			pst.setString(1, serviceDesc);
			pst.setString(2, price);
			pst.setString(3, status);
			pst.setString(4, serviceId);

			int count = pst.executeUpdate();
			if(count>0) 
			{
				userService = true;
			}
		} 
		catch (NamingException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return userService;
	}

	@Override
	public List<Service> getAllServiceDetails()
	{
		Connection con = null;
		List<Service> serviceList = new ArrayList<Service>();

		try 
		{
			InitialContext context = new InitialContext();  //Entry point to JNDI naming registry
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pgsql");
			con  = ds.getConnection(); 
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT serviceid,servicedesc,price,status FROM service");

			while(rs.next()) 
			{
				Service service =  new Service(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4));
				serviceList.add(service);
			}
		} 
		catch (NamingException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return serviceList;
	}

}
