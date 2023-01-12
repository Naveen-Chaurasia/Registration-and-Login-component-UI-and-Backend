package com.naveen.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/user/{name}")
	public ResponseEntity<?> getUSerById(@PathVariable String name)
	{
		
		Map<String, Object> map = new LinkedHashMap<String,Object>();
		try
		{
			User user = userService.findByName(name); 
			map.put("status", 1);
			map.put("data",user);
		    //Map header = new HttpHeaders();
			return new ResponseEntity<>(map,HttpStatus.OK);
		    
		}
		
		catch(Exception e)
		{
			
			map.put("status", 0);
			map.put("message","data is not found");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User user)
	{
		userService.addUsers(user);
		return ResponseEntity.ok(user);
	}
	


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
