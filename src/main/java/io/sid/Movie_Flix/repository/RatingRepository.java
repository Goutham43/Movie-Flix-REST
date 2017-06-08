package io.sid.Movie_Flix.repository;

import java.util.List;

import io.sid.Movie_Flix.entity.Movie;
import io.sid.Movie_Flix.entity.Rating;
import io.sid.Movie_Flix.entity.User;

public interface RatingRepository {
	
	public List<Rating> findAll(Movie movie);
	public Rating findOne(String id);
	public Rating create(Rating rating);
	public void delete(Rating rating); 
}
