package com.code.mvc.services;

import java.util.List;

import com.code.mvc.entity.Item;

public interface IItemService {

	public int createItem(Item item);
	public List<Item> getItems();
	public Item getItemById(int id);
	public int updateItem(Item item);
	public Item updateFile(int id, String fileNamePath);
	public int deleteItemById(int id);

}
