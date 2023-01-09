package com.naveen.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.naveen.repo.UserRepo;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepo userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		
		System.out.println("***************************************");
		com.naveen.model.User user = userRepository.findByName(username);
		System.out.println("***************************************");
		System.out.println(user);
		if (user!=null)
		{
			
			String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
			return new User(user.getName(),encodedPassword,new ArrayList<>());
		} 
		else 
		{
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}