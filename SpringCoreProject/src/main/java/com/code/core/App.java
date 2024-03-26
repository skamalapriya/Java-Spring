package com.code.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.code.entity.Baseball;
import com.code.entity.Coach;
import com.code.entity.Cricket;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     /* System.out.println( "Hello World!" );
    	Coach basketball = new Baseball();
    	System.out.println(basketball.getDailyWorkOut());*/ 

    	
    	//Create the spring container i.e. ApplicationContext is the spring IOC container
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

    	Coach coach = (Coach)context.getBean("baseball");
    	System.out.println("Coach: " + coach);
    	System.out.println(coach.getDailyWorkOut());
    	/*Though "Baseball" is a class that implements "Coach", "getDailyFortune() is not declared in "Coach".
    	  getDailyFortune() is a method belonging to a service class "FortuneService" whose object is passed
    	  on to the constructor of Baseball class. So, here it's sort of "FortuneService" tightly coupled to
    	  "Baseball" class. To access getDailyFortune() in this case is possible, only when I explicitly typecast
    	   object named coach into "Baseball"'s. So, option-1 will give a neat code.*/
    //	System.out.println(((Baseball)coach).getDailyFortune());
    	
    	/* option-1: Declare "getDailyFortune() in "Coach" interface and implement in the descendent classes
    	  ("Baseball" or "Cricket") and pass the "FortuneService" object to their("Baseball" or "Cricket")
    	   constructors and call getDailyFortune() on the "FortuneService"'s object*/
    	System.out.println(coach.getDailyFortune());
    	
    	//Cricket object-1
    	coach = (Coach)context.getBean("cricket");
    	System.out.println("Coach: " + coach);
    	System.out.println(coach.getDailyWorkOut());
    	System.out.println(coach.getDailyFortune());
    	
    	/*Cricket object-2 because calling getBean() will fetch newer object of Cricket class as we have given
    	  scope as "prototype" in <bean> tag*/ 
    	coach = (Coach)context.getBean("cricket");
    	System.out.println("Coach: " + coach);
    	System.out.println(coach.getDailyWorkOut());
    	System.out.println(coach.getDailyFortune());
    	
    	
    }
}
