package com.example.restapi.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.restapi.bean.FindUserResponse;
import com.example.restapi.bean.User;
import com.example.restapi.repository.UserRepository;
import com.example.restapi.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void findUserById()

	{
		String name = "saru";
		String url = "http://localhost:9090/userbyName?name=" + name;

		try {

			ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

			System.out.println(responseEntity);

			System.out.println(responseEntity.getBody());

			ObjectMapper objects = new ObjectMapper();

			FindUserResponse[] response = objects.readValue(responseEntity.getBody().toString(),
					FindUserResponse[].class);

			List<FindUserResponse> users = Arrays.asList(response);

			users.forEach(u -> {
				User user = new User();
				user.setFirstName(u.getFirstName());
				user.setLastName(u.getLastName());
				user.setCareer(u.getCareer());
				user.setStatus(responseEntity.getStatusCode().toString());
				repository.save(user);

			});

			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				System.out.println("response received");
				System.out.println(responseEntity.getBody());
			} else {
				System.out.println("error occurred");
				System.out.println(responseEntity.getStatusCode());
			}
		} catch (Exception e) {

			System.out.println(e);

		}

	}
}
