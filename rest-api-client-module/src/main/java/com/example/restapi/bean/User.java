package com.example.restapi.bean;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {
		
		@Id
		private long id;

		private String firstName;

		private String lastName;

		private String career;
		
		private String status;

	}
