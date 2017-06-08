package io.sid.Movie_Flix.controller;


import io.sid.Movie_Flix.entity.Rating;
import io.sid.Movie_Flix.service.MovieService;
import io.sid.Movie_Flix.service.RatingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="ratings")
public class RatingController {
	
	@Autowired
	RatingService service;
	
	@Autowired
	MovieService mService;
	
	@RequestMapping(method=RequestMethod.GET, path="movie/{movieId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Rating> findAll(@PathVariable("movieId") String movieId){
		
		//Movie movie = mService.findOne(movieId);
		return service.findAll(movieId);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating findOne(@PathVariable("id") String ratingId){
		
		return service.findOne(ratingId);
	
	}
	
	@RequestMapping(method=RequestMethod.POST, path="movie", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating create(@RequestBody Rating rating ){
		
		//return service.create(rating);
		return null;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("id") String ratingId){
		
		service.delete(ratingId);
		
	}
}
