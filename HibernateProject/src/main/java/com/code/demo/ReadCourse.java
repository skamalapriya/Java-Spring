package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Course;

public class ReadCourse {
	public ReadCourse(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Course> courses = session.createQuery("from Course").getResultList();
		
		for(Course course: courses) {
			System.out.println(course.toString());
		}
		
		session.close();
	}
}
