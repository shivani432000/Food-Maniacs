package com.shivani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.model.User;
import com.shivani.repository.UserRepository;
import com.shivani.service.UserService;

@RestController
public class UserController {

//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
//	
//	@PostMapping("/users")
//	public User createUser(@RequestBody User user) throws Exception{
//		
//	     User isExist = userRepository.findByEmail(user.getEmail());
//	     if(isExist!=null)
//	     {
//	    	throw new Exception("user already exists with email "+user.getEmail()); 
//	     }
//	    
//		User savedUser=userRepository.save(user);
//		
//		return savedUser;
//	}
//	
	
//	@DeleteMapping("/users/{userId}")
//	public String deleteUser(@PathVariable Long userId) throws Exception{
//		
//		userRepository.deleteById(userId);
//		
//		return "user deleted successfully";
//	}
	
//	@GetMapping("/users")
//	public List<User> getAllUsers() throws Exception{
//		
//		List<User> users = userRepository.findAll();
//		
//		return users;
//	}
	
//	public User findByEmail(String email) throws Exception
//	{
//	     User user = userRepository.findByEmail(email);
//	     if(user==null)
//	     {
//	    	throw new Exception("user not found with email"+email); 
//	     }
//	     return user;
//	}
	
}
