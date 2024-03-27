package com.code.demo;

import java.util.List;

//
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.InstructorProfile;

public class ReadInstructor {
	public ReadInstructor(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//Writing HQL passing Java objects using createQuery()that returns a Query object
/*		Query query = session.createQuery("from InstructorProfile");
		List<InstructorProfile> inst_profiles = query.getResultList();*/
		
		List<InstructorProfile> instructorprofiles = session.createQuery("from InstructorProfile").getResultList();
		for(InstructorProfile profile: instructorprofiles) {
			System.out.println(profile.toString());
		}
		
		session.close();
	}
}
