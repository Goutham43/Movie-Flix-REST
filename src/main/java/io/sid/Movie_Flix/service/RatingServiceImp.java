package io.sid.Movie_Flix.service;

import io.sid.Movie_Flix.entity.Movie;
import io.sid.Movie_Flix.entity.Rating;
import io.sid.Movie_Flix.entity.User;
import io.sid.Movie_Flix.exception.RatingNotFoundException;
import io.sid.Movie_Flix.repository.MovieRepository;
import io.sid.Movie_Flix.repository.RatingRepository;
import io.sid.Movie_Flix.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RatingServiceImp implements RatingService {
	
	@Autowired
	RatingRepository repository;
	
	@Autowired
	MovieRepository mRepository;
	
	@Autowired
	UserRepository uRepository;
	
	@Override
	public List<Rating> findAll(String movieId) {
		Movie movie = mRepository.findOne(movieId);
		return repository.findAll(movie);
		
	}
	
	@Override
	public Rating findOne(String id) {
		
		Rating existing = repository.findOne(id);
		if(existing==null){
			throw new RatingNotFoundException("Rating not found with id: " + " Not Found!!" );
		}
		return existing;
	}
	
	@Override
	@Transactional
	public Rating create(Rating rating, String movieId, String userId) {
		
		Movie movie = mRepository.findOne(rating.getMovie().getId());
		User user = uRepository.findOne(rating.getUser().getId());
		
		//return repository.create(rating, movie, user);
		return null;
	}

	@Override
	@Transactional
	public void delete(String id) {
		
		Rating existing = repository.findOne(id);
		if(existing==null){
			throw new RatingNotFoundException("Rating not found with id: " + " Not Found!!" );
		}
		repository.delete(existing);
		
	}

}
