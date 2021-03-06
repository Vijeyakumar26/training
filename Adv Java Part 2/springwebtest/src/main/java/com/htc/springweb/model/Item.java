package com.htc.springweb.model;

public class Item 
{
	private int itemCode;
	private String itemDesc;
	private double  itemPrice;
	private int qoh;
	private String category;
	
	public Item() {
		super();
	}

	public Item(int itemCode, String itemDesc, double itemPrice, int qoh, String category) {
		super();
		this.itemCode = itemCode;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
		this.qoh = qoh;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", itemDesc=" + itemDesc + ", itemPrice=" + itemPrice + ", qoh=" + qoh
				+ ", category=" + category + "]";
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getQoh() {
		return qoh;
	}

	public void setQoh(int qoh) {
		this.qoh = qoh;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
