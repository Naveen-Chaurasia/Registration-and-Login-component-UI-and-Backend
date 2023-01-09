package com.naveen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.model.JwtResponse;
import com.naveen.model.User;
import com.naveen.service.UserService;

@RestController
public class UserController {
	
	
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User user)
	{
		userService.addUsers(user);
		return ResponseEntity.ok(user);
	}
	

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {

		List<User> user = userService.getUsers();
		return user;

	}

	@PostMapping("/adduser")
	public void addUser(@RequestBody User u) {

		userService.addUsers(u);
	}

	@DeleteMapping("/deleteuser")
	public void deleteUser(@RequestParam String name) {
		userService.deleteUser(name);

	}

	@PutMapping("/updateuser")
	public void updateUser(@RequestBody User c) {
		userService.updateUser(c);
	}

}
