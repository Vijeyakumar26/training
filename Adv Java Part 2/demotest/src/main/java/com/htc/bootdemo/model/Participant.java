package com.htc.bootdemo.model;

public class Participant 
{
	private int pno;
	private String pname;
	private String email;
	private double city;
	
	
	public Participant()
	{
	}


	public int getPno() {
		return pno;
	}


	public void setPno(int pno) {
		this.pno = pno;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public double getCity() {
		return city;
	}


	public void setCity(double city) {
		this.city = city;
	}


	public Participant(int pno, String pname, String email, double city) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.email = email;
		this.city = city;
	}


	@Override
	public String toString() {
		return "Participant [pno=" + pno + ", pname=" + pname + ", email=" + email + ", city=" + city + "]";
	}

	
	
}
