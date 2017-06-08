package io.sid.Movie_Flix.service;

import io.sid.Movie_Flix.entity.Movie;
import io.sid.Movie_Flix.exception.MovieAlreadyExistsException;
import io.sid.Movie_Flix.exception.MovieNotFoundException;
import io.sid.Movie_Flix.repository.MovieRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieServiceImp implements MovieService{

	@Autowired
	MovieRepository repository;
	
	@Override
	public List<Movie> findAll() {
		
		return repository.findAll();
		
	}

	@Override
	public Movie findOne(String id) {
		
		Movie existing = repository.findOne(id);
		if(existing==null){
			throw new MovieNotFoundException("Movie with id " + id + " Not Found!!");
		}
		return existing;
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		
		Movie existing = repository.findByTitle(movie.getTitle()); 
		if(existing!=null){
			throw new MovieAlreadyExistsException("Movie Title Already Exists: " + movie.getTitle());
		}
		return repository.create(movie);
	}

	@Override
	@Transactional
	public Movie update(String id, Movie movie) {
		
		Movie existing = repository.findOne(id);
		if(existing==null){
			throw new MovieNotFoundException("Movie with id " + id + " Not Found!!");
		}
		return repository.update(existing);
	}

	@Override
	@Transactional
	public void delete(String id) {
		
		Movie existing = repository.findOne(id);
		if(existing==null){
			throw new MovieNotFoundException("Movie with id " + id + " Not Found!!");
		}
		repository.delete(existing);
	}

	@Override
	public List<Movie> sortByIMDBRatings() {
		
		return repository.sortByIMDBRatings();
	}

	@Override
	public List<Movie> sortByYear() {
		
		return repository.sortByYear();
	}

	@Override
	public List<Movie> sortByIMDBVotes() {
		
		return repository.sortByIMDBVotes();
	}

	@Override
	public List<Movie> topRated(String type) {
		
		return repository.topRated(type);
	}

	@Override
	public List<Movie> freeText(String text) {
		
		return repository.freeText(text);
	}

}
