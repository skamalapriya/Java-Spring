package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Course;
import com.code.entity.Student;

public class CreateStudent {
	public CreateStudent(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Student student1 = new Student("Priya", "Selva", "priya@gmail.com", "(+1)-999-999-9999");
		List<Course> courses = session.createQuery("from Course").getResultList();
		Course course = courses.stream().filter(c -> c.getTitle().equals("Data Structures")).findAny().orElse(null);
		student1.addCourse(course);
		course = courses.stream().filter(c -> c.getTitle().equals("TOC")).findAny().orElse(null);
		student1.addCourse(course);
		session.save(student1);
		
		Student student2 = new Student("Malli", "Shanmugha", "malli@gmail.com", "+919999999999");
		course = courses.stream().filter(c -> c.getTitle().equals("Networking")).findAny().orElse(null);
		student2.addCourse(course);
		session.save(student2);
		
		session.getTransaction().commit();
		
		session.close();
		
		System.out.println("Student records with email_ids " + student1.getEmail_id() + "and " + student2.getEmail_id() + " created successfully");
	}
}
