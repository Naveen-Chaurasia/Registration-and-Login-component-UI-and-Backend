package com.naveen.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.naveen.model.User;

public interface UserRepo extends MongoRepository<User, String> {
	public User findByName(String name);

	//public List<User> findByLastName(String lastName);
}
