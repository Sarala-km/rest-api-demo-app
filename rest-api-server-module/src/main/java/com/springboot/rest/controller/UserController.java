package com.springboot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.entities.User;
import com.springboot.rest.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// Get the users

	@GetMapping("/users")
	public List<User> getUser() {

		return this.userService.getUser();
	}

	// Get the user by name

	@GetMapping("/userbyName")
	public ResponseEntity<List<User>> getUserName(@RequestParam("name") String name) {

		List<User> result = this.userService.getUserName(name);

		return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);

	}

	// Add new user

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);

	}

}
