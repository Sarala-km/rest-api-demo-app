package com.example.restapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.restapi.service.UserService;

@RestController
@RequestMapping("myApp")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserService userService;

	@GetMapping("users")
	public List<Object> getUser() {

		String url = "http://localhost:9090/users";
		Object[] objects = restTemplate.getForObject(url, Object[].class);

		return Arrays.asList(objects);
	}

	@GetMapping("userbyName")
	public void findUserById()
	{
		userService.findUserById();
	}
}
