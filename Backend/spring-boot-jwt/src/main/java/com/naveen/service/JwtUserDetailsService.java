package com.naveen.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.naveen.repo.UserRepo;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepo userRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
//	{
//		
//		System.out.println("***************************************");
//		com.naveen.model.User user = userRepository.findByName(username);
//		System.out.println("***************************************");
//		System.out.println(user);
//		if (user"javainuse")
//		{
//			
//			
//			return new User("javainuse","$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",new ArrayList<>());
//		} 
//		else 
//		{
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
//			com.naveen.model.User user = userRepository.findByName(username);
//			
//			if(user!=null)
//			{
//				System.out.println("****************************");
//				
//				System.out.println(user.getName());
//				
//				return new User(user.getName(), "$2a$04$ux/DYTxqqYsp/PT9wlG.HeXsSRbrq8f.BFij76E0zVs14HHkUMX56",
//						new ArrayList<>());	
//			}
			
			//if ("javainuse".equals(username)) 
			System.out.println("****************************"+username);
			com.naveen.model.User user = userRepository.findByName(username);	
			System.out.println("((((((((((((("+user);
			if(user!=null){
				
				System.out.println("inside userdetail##############");
				return new User(user.getName(), user.getPassword(),new ArrayList<>());
				
			} 
			else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
		}

}