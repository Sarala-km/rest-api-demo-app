package com.springboot.rest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.dao.UserRepository;
import com.springboot.rest.entities.User;
import com.springboot.rest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUser() {
		return userRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> getUserName(String name) {

		return userRepository.findByFirstName(name);
	}

}
