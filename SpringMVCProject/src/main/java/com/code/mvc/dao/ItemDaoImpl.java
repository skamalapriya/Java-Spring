package com.code.mvc.dao;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

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
		return item.getItemId();
	}

	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		List<Item> items = session.createQuery("from Item").getResultList();
		return items;
	}

	@Override
	public Item getItemById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Item item = session.get(Item.class, id);
		return item;
	}

	@Override
	public int updateItem(Item item) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(item);
		return item.getItemId();
	}

	@Override
	public Item updateFile(int id, String fileNamePath) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Item item = session.get(Item.class, id);
		if(item != null) {
			Field field = ReflectionUtils.findField(Item.class, "fileName");
			field.setAccessible(true);
			ReflectionUtils.setField(field, item, fileNamePath);
			session.save(item);
			return item;
		}
		return null;
	}

	@Override
	public int deleteItemById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Item item = session.get(Item.class, id);
		session.remove(item);
		return 1;
	}

}
