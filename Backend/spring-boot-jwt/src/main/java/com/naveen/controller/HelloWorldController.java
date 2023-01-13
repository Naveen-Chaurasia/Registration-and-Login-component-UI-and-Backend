package com.naveen.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class HelloWorldController {
	
	
	@RequestMapping({"/kill"})
	public void kill()
	{
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");	
	System.out.println(	System.getenv());
	
	System.exit(8);
	}

	@RequestMapping({ "/hello" })
	public String hello() {
		return "Hello World";
	}

}
