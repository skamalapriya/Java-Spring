package com.code.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.entity.Course;
import com.code.entity.Instructor;
import com.code.entity.InstructorProfile;
import com.code.entity.Student;

public class App {
  public static void main(String[] args) {
    //System.out.println("Hello World!");
	  SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			  											 .addAnnotatedClass(Instructor.class)
			  											 .addAnnotatedClass(InstructorProfile.class)
			  											 .addAnnotatedClass(Course.class)
			  											 .addAnnotatedClass(Student.class)
			  											 .buildSessionFactory();
	/* The below line of code says that once when we create a Configuration object, we first configure the "hibernate.cfg.xml" file to that object
	 * and then map all the Java object model files(Instructor, InstructorProfile etc.,) to that object. Once when the object is setup with all
	 * the requirements(which is configuring the "hibernate.cfg.xml" file and mapping all the required classes,   
	  
	  Configuration config = new Configuration();
	  
	  config.configure("hibernate.cfg.xml");
	  config.addAnnotatedClass(Instructor.class);
	  config.addAnnotatedClass(InstructorProfile.class);
	  
	  SessionFactory sessionFactory = config.buildSessionFactory();*/
	  
	  //new CreateInstructor(sessionFactory);
	  //new ReadInstructor(sessionFactory);
	  //new CreateCourse(sessionFactory);
	  //new ReadCourse(sessionFactory);
	  //new CreateStudent(sessionFactory);
	  //new ReadStudent(sessionFactory);
	  
	  
	
	  
  }
}
