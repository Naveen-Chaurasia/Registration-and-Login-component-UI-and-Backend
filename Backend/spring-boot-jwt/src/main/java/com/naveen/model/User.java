package com.naveen.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	@Id
	public String id;
	
	@JsonProperty(value = "name")
	private String name;
	
	
   @JsonProperty(value = "password")
	private String password;


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}
	

}
