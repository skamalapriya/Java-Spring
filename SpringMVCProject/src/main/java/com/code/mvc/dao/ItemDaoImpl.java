package com.code.mvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.mvc.entity.Item;

@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public int createItem(Item item) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		session.save(item);
		
		return 0;
	}

}
