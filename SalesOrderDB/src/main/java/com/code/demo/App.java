package com.code.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.entity.Category;
import com.code.entity.OrderDetails;
import com.code.entity.Orders;
import com.code.entity.Product;
import com.code.entity.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
    		                                              .addAnnotatedClass(Category.class)
    		                                              .addAnnotatedClass(Product.class)
    		                                              .addAnnotatedClass(User.class)
    		                                              .addAnnotatedClass(Orders.class)
    		                                              .addAnnotatedClass(OrderDetails.class)
    		                                              .buildSessionFactory();
       
       //new CreateCategory(sessionFactory);
       //new CreateProduct(sessionFactory);
       //new CreateUser(sessionFactory);
       new CreateOrders(sessionFactory);
    }
}
