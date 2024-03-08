package com.code.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/* 
 * Roles of "ModelandView" class can be any one of the below:
 * 1. Create and return an object of its own i.e. ModelandView class inside any of the Controller's methods.
 * 2. While creation of its object, it takes a view-name i.e. in our case a jsp view file as an argument to
 *    its constructor.
 * 3. In its constructor, it takes view-name and model as parameters thereby the model's attribute values are
 *    passed on to the view page "view-name".
 *    
 *    
 *    
 * What is a model object in "Model model;" and its use??
 * 1. Controller passes info to View using model object. 
 */

@Controller
public class HomeController {
	/*
	 * In this case, @RequestMapping maps the request end-point "/" to the method "test", which returns a view
	 *page called "home" as an ModelandView object.  
	 */
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	//end-point "login" request is returned with the response of "login.jsp" file.
	@RequestMapping(value="login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	/*
	 * "checkLogin" is a controlled request which happened as a result of submitting the credentials in the
	 * login form of "login.jsp" file 
	 */
	@RequestMapping(value = "checkLogin", method = RequestMethod.POST)
	public ModelAndView checkLogin(HttpServletRequest request, Model model) {
		/* "request" object retrieves the uname(id of username input field of "login" form) using getParameter()
		 * and stores it in "userName"*/
		String userName = request.getParameter("uname");
		String passwd = request.getParameter("passwd");
		
		System.out.println("Username: " + userName);
		/* "userName"'s value is assigned to a variable called "user_name" and added as an attribute to the 
		 * model so that whenever Controller wants to pass-on this info, Controller can use model to pass-on this
		 * value by accessing model's attribute "user_name".*/
		model.addAttribute("user_name", userName);
		
		if(userName.equals("Priya") && passwd.equals("Selva"))
			/* Controller passes on the value to the "welcome.jsp" view using model so that "welcome.jsp"
			 * file uses the "user_name" attribute's value in its file.*/
			return new ModelAndView("welcome", "", model);
		return new ModelAndView("error");
		
	}
	
	//end-point "registration" request is returned with the response of "registration.jsp" file.
	@RequestMapping(value = "registration")
	public ModelAndView registration() {
		return new ModelAndView("userRegistration");
	}
	
	/*
	 * "saveUser" is a controlled request which happened as a result of submitting the credentials in the
	 * registration form of "registration.jsp" file 
	 */
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public ModelAndView userSave(HttpServletRequest request, Model model) {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String country = request.getParameter("country");
		String gender = request.getParameter("gender");
		String language = "";
		if(request.getParameter("lang") != null)
			language += request.getParameter("lang") + ", ";
		if(request.getParameter("lang1") != null)
			language += request.getParameter("lang1") + ", ";
		if(request.getParameter("lang2") != null)
			language += request.getParameter("lang2");
		
		System.out.println("FirstName: " + fname);
		System.out.println("LastName: " + lname);
		System.out.println("Country: " + country);
		System.out.println("Gender: " + gender);
		System.out.println("Languages: " + language);
		
		model.addAttribute("f_name", fname);
		model.addAttribute("l_name", lname);
		model.addAttribute("country", country);
		model.addAttribute("gender", gender);
		model.addAttribute("language", language);
		
		return new ModelAndView("confirm","", model);
	}
}
