package com.example.restapi.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FindUserResponse {

	@JsonProperty("id")
	private long id;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("career")
	private String career;

}
