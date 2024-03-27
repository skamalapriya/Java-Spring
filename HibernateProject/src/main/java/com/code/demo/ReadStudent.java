package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Student;

public class ReadStudent {
	public ReadStudent(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		List<Student> students = session.createQuery("from Student").getResultList();
		
		for(Student student: students) {
			System.out.println(student.toString());
		}
		
		session.close();
	}
}
