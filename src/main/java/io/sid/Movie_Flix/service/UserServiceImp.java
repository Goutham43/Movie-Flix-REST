package io.sid.Movie_Flix.service;

import io.sid.Movie_Flix.entity.User;
import io.sid.Movie_Flix.exception.UserAlreadyExistsException;
import io.sid.Movie_Flix.exception.UserNotFoundException;
import io.sid.Movie_Flix.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Override
	public List<User> findAll() {
		
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		
		User existing = repository.findOne(id);
		if(existing==null){
			throw new UserNotFoundException("User with" + id + "Not Found!!");
		}
		return existing;
	}

	@Override
	@Transactional
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if(existing!=null){
			throw new UserAlreadyExistsException("User Already Exists with email:" + user.getEmail());
		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existing = repository.findOne(id);
		if(existing==null){
			throw new UserNotFoundException("User with" + id + "Not Found!!");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findOne(id);
		if(existing==null){
			throw new UserNotFoundException("User with" + id + "Not Found!!");
		}
		repository.delete(existing);
	}

	@Override
	public User findByEmailPass(String email, String password) {
		User existing = repository.findByEmailPass(email, password);
		if(existing==null){
			throw new UserNotFoundException("User with email:"+" "+email+" "+"Not Found!!");
		}
		return existing;
	}

}
