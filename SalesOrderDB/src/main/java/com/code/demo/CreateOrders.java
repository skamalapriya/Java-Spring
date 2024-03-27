package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

//import com.code.entity.Category;
import com.code.entity.OrderDetails;
import com.code.entity.Orders;
import com.code.entity.Product;
import com.code.entity.User;

public class CreateOrders {
	public CreateOrders(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		List<Product> products = session.createQuery("from Product").getResultList();
		Product product1 = products.stream().filter(c -> c.getProduct_name().equals("Clover")).findAny().orElse(null);
		Product product2 = products.stream().filter(c -> c.getProduct_name().equals("Reebok")).findAny().orElse(null);
		Product product3 = products.stream().filter(c -> c.getProduct_name().equals("Pavoi")).findAny().orElse(null);
		List<User> users= session.createQuery("from User").getResultList();
		User user1 = users.stream().filter(c -> c.getUser_id() == 1).findAny().orElse(null);
		Orders order = new Orders("06/28/2023", 50, user1);
		OrderDetails orderDetail1 = new OrderDetails(2, product1, order, 20);
		OrderDetails orderDetail2 = new OrderDetails(2, product2, order, 10);
		OrderDetails orderDetail3 = new OrderDetails(1, product3, order, 20);
		
	//	orderDetail.addProducts(product);
		
		order.addOrders(orderDetail1);
		order.addOrders(orderDetail2);
		order.addOrders(orderDetail3);
		
		session.save(order);
		
		session.getTransaction().commit();
		session.close();
	}

}
