package com.htc.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection
{
	private String driverName;
	private String url;
	private String username;
	private String password;
	
	public Connection getConnection() throws IOException, SQLException, ClassNotFoundException
	{
		FileReader fr = new FileReader("db.properties");
		Properties prop = new Properties();
		prop.load(fr);
		
		driverName = prop.getProperty("driverName");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		//register the driver class name
		Class.forName(driverName);
		//obtaining connection
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
}

