package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modal.users;

public interface usersRepo extends MongoRepository<users, String> {


	
	
}
