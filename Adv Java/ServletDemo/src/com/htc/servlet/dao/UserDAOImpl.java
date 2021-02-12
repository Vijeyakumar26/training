package com.htc.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.htc.servlet.bo.User;

public class UserDAOImpl implements UserDAO 
{

	@Override
	public boolean addUser(User user)
	{
		boolean insertStatus = false;
		Connection con = null;
		try 
		{
			InitialContext context = new InitialContext();  //Entry point to JNDI naming registry
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pgsql");
			con  = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("insert into users values(?,?,?,?,?,?)");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getAddress());
			pst.setString(4, user.getContactno());
			pst.setString(5, user.getEmail());
			pst.setString(6, user.getGender());
			int result = pst.executeUpdate();
			if (result == 1)
				insertStatus = true;
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
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return insertStatus;
	}

	@Override
	public User getUser(String username) {
		Connection con = null;
		User user = null;
		try {
			InitialContext context = new InitialContext();  //Entry point to JNDI naming registry
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pgsql");
			con  = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("select username, password, address, contactno, email, gender from users where username = ?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) 
			{
				user = new User(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
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
		return user;
	}

	@Override
	public boolean deleteUser(String username) 
	{
		boolean insertStatus = false;
		Connection con = null;
		try 
		{
			InitialContext context = new InitialContext();  //Entry point to JNDI naming registry
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pgsql");
			con  = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("delete from users where username=?");
			pst.setString(1, username);
			int result = pst.executeUpdate();
			if (result == 1)
				insertStatus = true;
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
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return insertStatus;
	}

	@Override
	public boolean updateUser(String username, String contactno) 
	{
		boolean insertStatus = false;
		Connection con = null;
		try 
		{
			InitialContext context = new InitialContext();  //Entry point to JNDI naming registry
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pgsql");
			con  = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("update users set contactno = ? where username = ?");
			pst.setString(1, contactno);
			pst.setString(2, username);
			int result = pst.executeUpdate();
			if (result == 1)
				insertStatus = true;
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
		return insertStatus;
	}

	@Override
	public boolean validateUser(String username, String password) 
	{
		Connection con = null;
		boolean userExists = false;
		try {
			InitialContext context = new InitialContext();  //Entry point to JNDI naming registry
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pgsql");
			con  = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("select count(*) from users where username = ? and password =?");
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) 
			{
				if(rs.getInt(1)==1)
				{
					userExists = true;
				}
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userExists;
	}
}
