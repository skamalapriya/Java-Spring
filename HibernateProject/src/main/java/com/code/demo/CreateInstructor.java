package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Instructor;
import com.code.entity.InstructorProfile;

public class CreateInstructor {
	//private SessionFactory sessionFactory;
	
	public CreateInstructor(SessionFactory sessionFactory) {
		
		//this.sessionFactory = sessionFactory;
		
		//Creating the session object using sessionFactory
		Session session = sessionFactory.getCurrentSession();
		//start a transaction using session object 
		session.beginTransaction();
		
		//Creating the objects for Instructor and InstructorProfile classes
		Instructor instructor = new Instructor("Selva", "Jeyakumar", "selva@gmail.com");
		InstructorProfile instructorProfile = new InstructorProfile("MBA", "Playing cricket", instructor);
		//inserting a row into instructor table and eventually into instructor_profile table. First, it will check if the foreign key "instructor" has an entry, if not then it creates and then creates a row in instructor_profile table  
		session.save(instructorProfile);
		
		instructor = new Instructor("Aruni", "J.S", "aruni@gmail.com");
		instructorProfile = new InstructorProfile("4th grade", "Singing", instructor);
		session.save(instructorProfile);
		
		instructor = new Instructor("Gopi", "J.S", "gopi@gmail.com");
		instructorProfile = new InstructorProfile("6th grade", "Anime drawing", instructor);
		session.save(instructorProfile);
		
		//committing the current status of the database
		session.getTransaction().commit();
		//session is for a short span of time. So, once when work done, it has to be closed.
		session.close();
		
		System.out.println("An instructor record is created with id: " + instructor.getId());
	}

}
