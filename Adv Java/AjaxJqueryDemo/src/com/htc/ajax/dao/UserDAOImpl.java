package com.htc.ajax.dao;

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

import com.htc.ajax.entity.User;

public class UserDAOImpl implements UserDAO
{

	@Override
	public boolean checkUsername(String username)
	{
		Connection con = null;
		boolean userFound = false;
		try {
			InitialContext context = new InitialContext();  //Entry point to JNDI naming registry
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pgsql");
			con  = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("select count(*)  from users where username = ?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1) == 1) {
					userFound = true;
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
		return userFound;
	}

	@Override
	public User getUser(String username) 
	{
		Connection con = null;
		User user = null;
		try {
			InitialContext context = new InitialContext();  //Entry point to JNDI naming registry
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pgsql");
			con  = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("select username, password, address, contactno, email, gender from users where username = ?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				user = new User(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
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
		return user;
	}

	@Override
	public boolean updateUser(String username, String address, String email, String contact)
	{
		Connection con = null;
		boolean userUpdated = false;
		try {
			InitialContext context = new InitialContext();  //Entry point to JNDI naming registry
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pgsql");
			con  = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("update users set address=?, contactno=?, email=?  where username = ?");
			pst.setString(1, address);
			pst.setString(2, contact);
			pst.setString(3, email);
			pst.setString(4, username);

			int count = pst.executeUpdate();
			if(count>0) 
			{
				userUpdated = true;
			}
		} 
		catch (NamingException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userUpdated;
	}

	@Override
	public List<User> getAllUsers() {
		Connection con = null;
		List<User> userList = new ArrayList<User>();

		try 
		{
			InitialContext context = new InitialContext();  //Entry point to JNDI naming registry
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pgsql");
			con  = ds.getConnection(); 
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select username, password, address, contactno, email, gender from users");

			while(rs.next()) 
			{
				User user =  new User(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				userList.add(user);
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
		return userList;
	}
}
