package com.htc.customer.entity;

import java.util.ArrayList;

public class Bank
{
	private ArrayList <Customer> cus;
	private String bankname;
	private String bankid;
	
	public Bank(ArrayList <Customer> cus, String bankname, String bankid) 
	{
		super();
		this.cus = cus;
		this.bankname = bankname;
		this.bankid = bankid;
	}
	
	public ArrayList <Customer> getCus() 
	{
		return cus;
	}

	public void setCus(ArrayList <Customer> cus)
	{
		this.cus = cus;
	}
	
	public void setBankname(String bankname)
	{
		this.bankname = bankname;
	}

	public String getBankid() {
		return bankid;
	}

	public void setBankid(String bankid) {
		this.bankid = bankid;
	}

	@Override
	public String toString() {
		return "Bank [cus=" + cus + ", bankname=" + bankname + ", bankid=" + bankid + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankid == null) ? 0 : bankid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (bankid == null) {
			if (other.bankid != null)
				return false;
		} else if (!bankid.equals(other.bankid))
			return false;
		return true;
	}
}
