package com.htc.springweb.service;

import java.util.List;

import com.htc.springweb.model.Item;

public interface ItemService
{
	public boolean addItem(Item item);
	public boolean updateItem(Item itm);
	public Item getItem(int itemCode);
	public List<Item> getItems();
}
