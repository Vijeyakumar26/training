package com.htc.ajax.dao;

import com.htc.ajax.entity.User;

public interface UserDAO
{
	public boolean checkUsername(String username);
	public User getUser(String username);
	public boolean updateUser(String username, String address, String email, String contact);
}
