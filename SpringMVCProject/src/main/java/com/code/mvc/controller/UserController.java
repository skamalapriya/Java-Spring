package com.code.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.code.mvc.entity.Users;
import com.code.mvc.services.IUserService;

@Controller
@RequestMapping(value="users/")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value="add")
	public ModelAndView addUser(Model model) {
		/* 
		 * step-1: An object of "Users.java" class is binded to a variable called "users".
		 * step-2: "users" is added as an attribute to the model.
		 */
		model.addAttribute("users", new Users());
	
		/* 
		 * for the url "add", controller returns the view "user_registration" to the browser(client)
		 * and the values entered for the user_registration form(view) by the user in the browser are 
		 * mapped to the model which in-turn stores the values into "users" attribute of the model.
		 */
		return new ModelAndView("user_registration", "", model);
	}
	
	@RequestMapping(value="saveuser", method = RequestMethod.POST)
	/*when we use @ModelAttribute(), this annotation binds the method parameter i.e. in our case "Users Usr"
	 *to the existing model's attribute i.e. in our case "users" which is passed as an argument to 
	 *@ModelAttribute() so that "users"'s values are retrieved into "usr".
	 */
	public ModelAndView user_save(@ModelAttribute("users")Users usr, Model model) {
		
		//Add(Create) or Edit(Update) credentials other than emailid for a particular user
		userService.createUser(usr);
		
		System.out.println(usr.getFirstname());
		System.out.println(usr.getLastname());
		System.out.println(usr.getCountry());
		System.out.println(usr.getGender());
		System.out.println(usr.getLanguage());
		model.addAttribute("user", usr);
		//"confirm1.jsp" is not used for timebeing bcoz we r trying to do for Admin purpose and not enduser
		//return new ModelAndView("confirm1", "", model);
		return new ModelAndView("redirect:/users/");
	}
	
	@RequestMapping(value="/")
	public ModelAndView userList(Model model) {
		List <Users> usrs = userService.getAllUsers();
		System.out.println(usrs);
		model.addAttribute("lstusers", usrs);
		return new ModelAndView("listuser","",model);
	}
	
	@RequestMapping(value="/edit/{emailid:.+}")
	public ModelAndView editList(@PathVariable("emailid") String email_id, Model model){
		Users usr = userService.getUserByEmailId(email_id);
		System.out.println("getUserByEmailId: " + email_id);
		model.addAttribute("users_update", usr);
		return new ModelAndView("update_user_registration", "", model);
	}
	
	@RequestMapping(value="/delete/{emailid:.+}")
	public ModelAndView deleteUserByEmail(@PathVariable("emailid") String emailid, Model model) {
		userService.deleteUser(emailid);
		return new ModelAndView("redirect:/users/");
	}
	
	@RequestMapping(value="updateuser", method = RequestMethod.POST, params = "submit")
	public ModelAndView user_update(@ModelAttribute("users_update")Users usr, Model model) {
		
		//Add(Create) or Edit(Update) credentials other than emailid for a particular user
		userService.updateUser(usr);
		
		System.out.println(usr.getFirstname());
		System.out.println(usr.getLastname());
		System.out.println(usr.getCountry());
		System.out.println(usr.getGender());
		System.out.println(usr.getLanguage());
//		model.addAttribute("user", usr);
		//"confirm1.jsp" is not used for timebeing bcoz we r trying to do for Admin purpose and not enduser
		//return new ModelAndView("confirm1", "", model);
		return new ModelAndView("redirect:/users/");
	}
	
	@RequestMapping(value="updateuser", params="delete")
	public ModelAndView deleteUser(@ModelAttribute("users_update") Users usr, Model model) {
		userService.deleteUser(usr);
		return new ModelAndView("redirect:/users/");
	}
}
