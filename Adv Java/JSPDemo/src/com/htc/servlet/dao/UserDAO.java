package com.htc.servlet.dao;

import java.util.List;

import com.htc.servlet.bo.User;

public interface UserDAO
{
	public boolean addUser(User user);
	public User getUser(String username);
	public boolean deleteUser(String username);
	public boolean updateUser(String username, String contactno);
	public boolean validateUser(String username, String password);
	
	public List<User> getAllUsers();
}
