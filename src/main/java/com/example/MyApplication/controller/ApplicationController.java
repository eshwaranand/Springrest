package com.example.MyApplication.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MyApplication.model.User;
import com.example.MyApplication.services.UserService;


@Controller 
public class ApplicationController  // this is the contorller 
{
	
	@Autowired
	public UserService userService;
	
	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) 
	{
		request.setAttribute("mode","MODE_HOME");
		return "welcomepage";
	}
	@RequestMapping("/register")
	public String registration(HttpServletRequest request) 
	{
		request.setAttribute("mode","MODE_REGISTER");
		return "welcomepage";
	}
	@PostMapping("/save-user")  // this is the method to call save user
	public String registerUSer(@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request) 
	{
		userService.SaveMyUser(user);
		request.setAttribute("mode","MODE_HOME");  
		return "welcomepage";
	}
	@GetMapping("/show-users")   // this is using list of the user
	public String showAllUsers(HttpServletRequest request) 
	{
		request.setAttribute("users",userService.showAllUsers());
		request.setAttribute("mode","ALL_USERS");
		return	"welcomepage";
		
	}
	@RequestMapping("/delete-user")   // this will be using for delete for the user data form the database 
	public String deleteUser(@RequestParam int id,HttpServletRequest request) 
	{
		userService.deleteMyUser(id);
		request.setAttribute("users",userService.showAllUsers());
		request.setAttribute("mode","ALL_USERS");
		return "welcomepage";
	}
	@RequestMapping("/edit-user")  // edit user will be update the user name password age and ect..,
	public String editUser(@RequestParam int id,HttpServletRequest request) 
	{
		request.setAttribute("user", userService.editUser(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "welcomepage"; 
	}
	
	@RequestMapping("/login") // this is the page to login show 
	public String login(HttpServletRequest request) 
	{
		request.setAttribute("mode","MODE_LOGIN");
		return "welcomepage";
	}
	@RequestMapping("/login-user")  // this is the condition to perform the task in login page / so userservice will provide the the medthod from userrepository  / userrepository will be in crud repository
	public String loginUser(@ModelAttribute User user,HttpServletRequest request) 
	{
		User isLogin = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());  // so why we are using means here the  to get the username and password in login page  
		if(isLogin != null)
		{
			return "homepage";
		}
		else 
		{
			request.setAttribute("error", "invalid Username or password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
		}
	}
}

 