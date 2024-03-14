package com.code.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.mvc.dao.IItemDao;
import com.code.mvc.entity.Item;

@Service
@Transactional //This does the session.beginTransaction() and session.commit()
public class ItemServiceImpl implements IItemService{

	@Autowired
	IItemDao itemDaoImpl;
	
	@Override
	public int createItem(Item item) {
		// TODO Auto-generated method stub
		return itemDaoImpl.createItem(item);
	}

	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return itemDaoImpl.getItems();
	}

	@Override
	public Item getItemById(int id) {
		// TODO Auto-generated method stub
		return itemDaoImpl.getItemById(id);
	}

	@Override
	public int updateItem(Item item) {
		// TODO Auto-generated method stub
		return itemDaoImpl.updateItem(item);
	}

	@Override
	public Item updateFile(int id, String fileNamePath) {
		// TODO Auto-generated method stub
		return itemDaoImpl.updateFile(id, fileNamePath);
	}

	@Override
	public int deleteItemById(int id) {
		// TODO Auto-generated method stub
		return itemDaoImpl.deleteItemById(id);
	}

}
