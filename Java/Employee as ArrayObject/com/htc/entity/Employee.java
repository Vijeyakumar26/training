package com.htc.entity;

public class Employee 
{
	private String empid;
	private String empName;
    private String dob;
    private String address;
    private String email;
    
    public Employee()
    {
		super();
	}
   
    public Employee(String empid, String empName, String dob, String address, String email) 
    {
		super();
		this.empid = empid;
		this.empName = empName;
		this.dob = dob;
		this.address = address;
		this.email = email;
	}
    
	public String getEmpid() 
	{
		return empid;
	}
	public void setEmpid(String empid) 
	{
		this.empid = empid;
	}
	public String getEmpName() 
	{
		return empName;
	}
	public void setEmpName(String empName) 
	{
		this.empName = empName;
	}
	public String getDob() 
	{
		return dob;
	}
	public void setDob(String dob) 
	{
		this.dob = dob;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
}
