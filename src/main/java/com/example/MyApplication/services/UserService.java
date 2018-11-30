package com.example.MyApplication.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.MyApplication.model.User;
import com.example.MyApplication.repository.UserRepository;

@Service
@Transactional
public class UserService 
{
	  private final UserRepository userRepository;
	  
	  public UserService(UserRepository userRepository) 
	  {
		  this.userRepository=userRepository;
	  }

	  public void SaveMyUser(User user) // this will be use for the given data will be stored by database 
	  {
		userRepository.save(user);
	  }
	
	  public List<User> showAllUsers()    // this is method will show the list of the user	
	  {
		List<User> users = new ArrayList<User>();    //   this will be user incrementing based the user stored in database 
		for(User user:userRepository.findAll()) 
		{
			users.add(user);
		}
		return users;
	  }
	
	
	  public void deleteMyUser(int id)   // this method will be the using for deleting 
	  	{
		  userRepository.deleteById(id);
	  	}
	
	
	  public User editUser(int id)      // this is the method to show update the user details 
	  {
		return userRepository.findById(id).orElse(null);
	  }

	
	  public User findByUsernameAndPassword(String username,String password)   // this is the method to call username and password 
	  {
		
		return userRepository.findByUsernameAndPassword(username, password );
		
	  }
	

}




