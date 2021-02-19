package com.example.restapi.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class FindUserResponseList {
	
	List<FindUserResponse> list;

	public FindUserResponseList(List<FindUserResponse> list) {
		this.list = new ArrayList<>();
	}
	
	

}
