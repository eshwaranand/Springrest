package com.example.MyApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MyApplication.model.User;
import com.example.MyApplication.services.UserService;

@org.springframework.web.bind.annotation.RestController

public class RestController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String hello() 
	{
	return "This is Home Page";
	}	
	
	@GetMapping("/save-user")
	public String saveUser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname, @RequestParam int age, @RequestParam String password) 
	{
		
		User user = new User(username,firstname,lastname,age,password);
		userService.SaveMyUser(user);
		return "User Saved";
	}
	
}	
