package com.springboot.rest.service;

import java.util.List;

import com.springboot.rest.entities.User;

public interface UserService {

	public List<User> getUser();
	
	public List<User> getUserName(String name);
	
	public User addUser(User user);

}
