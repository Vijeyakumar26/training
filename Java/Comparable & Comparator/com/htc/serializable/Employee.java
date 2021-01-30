package com.htc.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable
{
	public Employee(int empId, String empName, int age, double salary)
	{
		super();
		this.empId = empId;
		this.empName = empName;
		this.age = age;
		this.salary = salary;
	}
	private int empId;
	private String empName;
	private int age;
	private double salary;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", age=" + age + ", salary=" + salary + "]";
	}
	
	 private static final long serialVersionUID = 1L;
	    private transient Address address;
	    private Person person;

	    // setters and getters

	    private void writeObject(ObjectOutputStream oos) 
	      throws IOException {
	        oos.defaultWriteObject();
	        oos.writeObject(address.getHouseNumber());
	    }

	    private void readObject(ObjectInputStream ois) 
	      throws ClassNotFoundException, IOException
	    {
	        ois.defaultReadObject();
	        Integer houseNumber = (Integer) ois.readObject();
	        Address a = new Address();
	        a.setHouseNumber(houseNumber);
	        this.setAge(age);;
	    }
}
