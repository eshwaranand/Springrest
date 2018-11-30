package com.example.MyApplication.repository;

import org.springframework.data.repository.CrudRepository;


import com.example.MyApplication.model.User;


public interface UserRepository extends CrudRepository<User, Integer> 
{
	
	// login user will be take to parameters username and password 
	// the username and password should be the string format
	// findby is the  methods that shows the username and password from userrepository 

	
	
	// main thing if i commented in this page it was giving some error called The method findBy UsernameAndPassword(String, String) is undefined for the type UserRepository
	
	 public User findByUsernameAndPassword(String username, String password); 

}



