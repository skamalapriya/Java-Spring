package com.code.mvc.services;

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

}
