package com.naveen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.naveen.model.User;
import com.naveen.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	public User findByName(String name)
	{
		
		return userRepository.findByName(name);
		
	}

	public List<User> getUsers() {

		return userRepository.findAll();
	}

	public void addUsers(User u) {
		
		User us = new User();
		us.setName(u.getName());
		us.setPassword(bcryptEncoder.encode(u.getPassword()));
		userRepository.save(us);
		System.out.println("Added User with name: " + u);
	}

	public void deleteUser(String name) {
		User user = userRepository.findByName(name);
		userRepository.delete(user);
	}
	
	public void updateUser(User c) {
		userRepository.save(c);
		
	}

}
