package com.htc.springweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.htc.springweb.model.Item;

@Repository
public class ItemDAOImpl implements ItemDAO
{
	@Autowired //by type
	JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean addItem(Item item) 
	{
		int result = jdbcTemplate.update("insert into items values(?,?,?,?,?)", 
				item.getItemCode(), item.getItemDesc(), item.getItemPrice(), item.getQoh(),item.getCategory());
		if(result > 0) 
			return true;
		return false;
	}

	@Override
	public boolean updateItem(Item itm) {
		int result = jdbcTemplate.update("update items set qoh =? , itemPrice =? where itemcode= ?", itm.getQoh(),itm.getItemPrice(),itm.getItemCode());
		if(result>0) 
			return true;
		else
			return false;
	}

	@Override
	public Item getItem(int itemCode) 
	{
		Item item = null;
		item = jdbcTemplate.queryForObject("SELECT ITEMCODE, ITEMDESC, ITEMPRICE, QOH, CATEGORY FROM ITEMS where ITEMCODE = ?", 
				new Object[] {itemCode},
				new RowMapper<Item>() {
			@Override
			public Item mapRow(ResultSet rs, int arg1) throws SQLException {
				Item i = new Item();
				i.setItemCode(rs.getInt(1));
				i.setItemDesc(rs.getString(2));
				i.setItemPrice(rs.getDouble(3));
				i.setQoh(rs.getInt(4));
				i.setCategory(rs.getString(5));
				return i;
			}
		});
		return item;
	}

	@Override
	public List<Item> getItems()
	{
		List<Item> itemList = null;

		itemList = jdbcTemplate.query("SELECT ITEMCODE, ITEMDESC, ITEMPRICE, QOH, CATEGORY FROM ITEMS", 
				new RowMapper<Item>() {

			@Override
			public Item mapRow(ResultSet rs, int arg1) throws SQLException {
				Item i = new Item();
				i.setItemCode(rs.getInt(1));
				i.setItemDesc(rs.getString(2));
				i.setItemPrice(rs.getDouble(3));
				i.setQoh(rs.getInt(4));
				i.setCategory(rs.getString(5));
				return i;
			}
		});
		return itemList;
	}
}
