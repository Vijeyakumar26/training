package com.htc.springweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.htc.springweb.dao.ItemDAO;
import com.htc.springweb.model.Item;

@Service
public class ItemServiceImpl implements ItemService
{
	@Autowired
	ItemDAO itemdao;
	
	public ItemDAO getItemdao() {
		return itemdao;
	}

	public void setItemdao(ItemDAO itemdao) {
		this.itemdao = itemdao;
	}


	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor=java.lang.Exception.class)
	public boolean addItem(Item item) {
		try {
	
			return itemdao.addItem(item);
			//additioanl logic
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=true)
	public Item getItem(int itemCode) {
		return itemdao. getItem(itemCode);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=true)	
	public List<Item> getItems() {
		return itemdao.getItems();
	}
	

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor=java.lang.Exception.class)
	public boolean updateItem(Item itm) {
		return itemdao.updateItem(itm);
	}
	
}

