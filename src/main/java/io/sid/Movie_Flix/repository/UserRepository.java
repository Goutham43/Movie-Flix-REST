package io.sid.Movie_Flix.repository;

import io.sid.Movie_Flix.entity.User;

import java.util.List;

public interface UserRepository {
	
	public List<User> findAll();
	public User findOne(String id);
	public User findByEmail(String email);
	public User create(User user);
	public User update(User user);
	public void delete(User user);
	public User findByEmailPass(String email, String password); 

}

