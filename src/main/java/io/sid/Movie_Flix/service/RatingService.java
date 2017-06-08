package io.sid.Movie_Flix.service;


import io.sid.Movie_Flix.entity.Rating;

import java.util.List;

public interface RatingService {
	
	public List<Rating> findAll(String movieId);
	public Rating findOne(String id); 
	public Rating create(Rating rating, String movieId, String userId);
	public void delete(String id);
}
