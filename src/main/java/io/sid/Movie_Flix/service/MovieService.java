package io.sid.Movie_Flix.service;

import io.sid.Movie_Flix.entity.Movie;

import java.util.List;

public interface MovieService {
	
	public List<Movie> findAll();
	public Movie findOne(String id);
	public Movie create(Movie movie);
	public Movie update(String id, Movie movie);
	public void delete(String id);
	public List<Movie> sortByIMDBRatings();
	public List<Movie> sortByYear();
	public List<Movie> sortByIMDBVotes();
	public List<Movie> topRated(String type);
	public List<Movie> freeText(String text);
	
}
