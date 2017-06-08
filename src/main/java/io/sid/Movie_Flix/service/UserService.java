package io.sid.Movie_Flix.service;

import io.sid.Movie_Flix.entity.User;

import java.util.List;

public interface UserService {
	
	public List<User> findAll();
	public User findOne(String id);
	public User create(User user);
	public User update(String id, User user);
	public void delete(String id);
	public User findByEmailPass(String email,String password);
}
