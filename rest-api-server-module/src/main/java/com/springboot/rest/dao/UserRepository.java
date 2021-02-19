package com.springboot.rest.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.rest.entities.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findAll();

	
	@Query("select * from user where first_name=:firstName")
    List<User> findByFirstName(@Param("firstName") String firstName);


}