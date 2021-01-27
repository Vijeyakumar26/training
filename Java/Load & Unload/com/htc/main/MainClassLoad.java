package com.htc.main;

import java.io.IOException;
import java.sql.SQLException;

import com.htc.load.dto.CustomerLoadDTOImpl;

public class MainClassLoad
{
	public static void main(String[] args)
	{
		CustomerLoadDTOImpl cs=new CustomerLoadDTOImpl();

		try 
		{
			cs.readFile();
		} 
		catch (ClassNotFoundException | IOException | SQLException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Load Done");	
	}
}
