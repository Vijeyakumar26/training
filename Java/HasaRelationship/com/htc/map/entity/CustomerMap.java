package com.htc.map.entity;

public class CustomerMap 
{
	private int customerId;
	private String customerName;	
	private int accountNo;
	private String accountType;
	private double accountBalance;
	private String mailId;
	private int contactNo;
	
	public CustomerMap(int customerId, String customerName, int accountNo, String accountType, double accountBalance,
			String mailId, int contactNo)
	{
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.mailId = mailId;
		this.contactNo = contactNo;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	
	@Override
	public String toString() {
		return "CustomerMap [customerId=" + customerId + ", customerName=" + customerName + ", accountNo=" + accountNo
				+ ", accountType=" + accountType + ", accountBalance=" + accountBalance + ", mailId=" + mailId
				+ ", contactNo=" + contactNo + "]";
	}
	
	
}
