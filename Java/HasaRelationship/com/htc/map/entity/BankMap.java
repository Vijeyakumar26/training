package com.htc.map.entity;

import java.util.List;

public class BankMap 
{
	private List <CustomerMap> cus;
	private String bankname;
	private String bankid;
	
	public BankMap(List<CustomerMap> cus, String bankname, String bankid) {
		super();
		this.cus = cus;
		this.bankname = bankname;
		this.bankid = bankid;
	}

	public List<CustomerMap> getCus() {
		return cus;
	}

	public void setCus(List<CustomerMap> cus) {
		this.cus = cus;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
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
		return "BankMap [cus=" + cus + ", bankname=" + bankname + ", bankid=" + bankid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cus == null) ? 0 : cus.hashCode());
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
		BankMap other = (BankMap) obj;
		if (cus == null) {
			if (other.cus != null)
				return false;
		} else if (!cus.equals(other.cus))
			return false;
		return true;
	}
	
	
	
}
