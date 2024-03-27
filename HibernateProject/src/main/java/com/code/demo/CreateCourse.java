package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Course;
import com.code.entity.Instructor;

public class CreateCourse {
	public CreateCourse(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
/*		int instructor_id = 1;
		Instructor instructor = session.get(Instructor.class, instructor_id);*/
		
		//Pulling out the instructor records whose instructor id is 1
		List<Instructor> instructors = session.createQuery("from Instructor").getResultList();
		Instructor instructor = instructors.stream().filter(c -> c.getId() == 1).findAny().orElse(null);
		
		/*Creating a new course entry assigning one or more courses 
		  to a single instructor and parallelly saving the course records to the Course table*/
		Course course = new Course("Java Programming", 800, instructor);
		session.save(course);
		course = new Course("Data Structures", 1000, instructor);
		session.save(course);
		
		//Pulling out another instructor's record whose id is 2
		instructor = instructors.stream().filter(c -> c.getId() == 2).findAny().orElse(null);
		
		/*Creating and assigning courses to the instructor whose id is 2 and saving
		  courses records to the Course table*/
		course = new Course("Analysis of Algorithms", 900, instructor);
		session.save(course);
		course = new Course("Networking", 800, instructor);
		session.save(course);
		course = new Course("TOC", 500, instructor);
		session.save(course);
		
		session.getTransaction().commit();
		
		session.close();
		
		System.out.println("Courses are created and assigned to corresponding instructors");
	}
}
