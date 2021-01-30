package com.htc.entity;

public class Transaction
{
	private int transactionId;
	private int customerId;
	private double amount;
	
	public Transaction(int transactionId, int customer_id, double amount) 
	{
		super();
		this.transactionId = transactionId;
		this.customerId = customer_id;
		this.amount = amount;
	}

	public int getTransactionId()
	{
		return transactionId;
	}

	public void setTransactionId(int transactionId)
	{
		this.transactionId = transactionId;
	}

	public int getCustomer_id() {
		return customerId;
	}

	public void setCustomer_id(int customer_id) {
		this.customerId = customer_id;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	@Override
	public String toString() 
	{
		return "Transaction [transactionId=" + transactionId + ", customer_id=" + customerId + ", amount=" + amount
				+ "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}
}
