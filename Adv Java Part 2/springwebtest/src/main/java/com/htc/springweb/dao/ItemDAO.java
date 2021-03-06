package com.htc.springweb.dao;

import java.util.List;

import com.htc.springweb.model.Item;

public interface ItemDAO 
{
	public boolean addItem(Item item);
	public boolean updateItem(Item itm);
	public Item getItem(int itemCode);
	public List<Item> getItems();
}
