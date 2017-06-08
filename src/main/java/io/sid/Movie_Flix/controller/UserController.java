package io.sid.Movie_Flix.controller;

import io.sid.Movie_Flix.entity.User;


import io.sid.Movie_Flix.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="users")
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll(){
		
		return service.findAll();
	
	}
	
	
	@RequestMapping(method=RequestMethod.GET, path="{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findOne(@PathVariable("id")String userId){
	
		return service.findOne(userId);
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user){
		
		return service.create(user);
		
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, path="{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id")String userId, @RequestBody User user){
		
		return service.update(userId, user);
		
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("id")String userId){
	
		service.delete(userId);
	
	}
	
	
	@RequestMapping(method=RequestMethod.POST, path="login", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User Login(@RequestBody Login login){
		
		return service.findByEmailPass(login.email, login.password);
	
	}
	
	private static class Login{
		
		public String email;
		public String password;
		
	}
}
