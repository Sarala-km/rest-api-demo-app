package com.springboot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.springboot.rest.entities")
public class SpringbootrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestApplication.class, args);
	}

}
