package io.sid.Movie_Flix.repository;

import io.sid.Movie_Flix.entity.Movie;

import java.util.List;

public interface MovieRepository {
	
	public List<Movie> findAll();
	public Movie findOne(String id);
	public Movie findByTitle(String title);
	public Movie create(Movie movie);
	public Movie update(Movie movie);
	public void delete(Movie movie);
	public List<Movie> sortByIMDBRatings();
	public List<Movie> sortByYear();
	public List<Movie> sortByIMDBVotes();
	public List<Movie> topRated(String type);
	public List<Movie> freeText(String text);
	
}
