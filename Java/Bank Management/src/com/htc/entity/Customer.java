package com.htc.entity;

public class Customer
{
	private int customerId;
	private String customeName;
	private String accountType;
	private int availableBalance;
	
	public Customer(int customerId, String customeName, String accountType, int availableBalance) 
	{
		super();
		this.customerId = customerId;
		this.customeName = customeName;
		this.accountType = accountType;
		this.availableBalance = availableBalance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomeName() {
		return customeName;
	}

	public void setCustomeName(String customeName) {
		this.customeName = customeName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(int availableBalance) {
		this.availableBalance = availableBalance;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customeName=" + customeName + ", accountType=" + accountType
				+ ", availableBalance=" + availableBalance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
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
		Customer other = (Customer) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}
	
}
