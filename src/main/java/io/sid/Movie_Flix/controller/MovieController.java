package io.sid.Movie_Flix.controller;

import io.sid.Movie_Flix.entity.Movie;
import io.sid.Movie_Flix.service.MovieService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="movies")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("id") String movieId){
		return service.findOne(movieId);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie){
		return service.create(movie);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id")String movieId, @RequestBody Movie movie){
		return service.update(movieId, movie);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("id")String movieId){
		service.delete(movieId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="imdbRatings/{imdbRatings}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByIMDBRatings(){
		return service.sortByIMDBRatings();
		
	}
	
	@RequestMapping(method=RequestMethod.GET, path="year/{year}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByYear(){
		return service.sortByYear();
		
	}
	
	@RequestMapping(method=RequestMethod.GET, path="imdbVotes/{imdbVotes}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByIMDBVotes(){
		return service.sortByIMDBVotes();
		
	}
	
	@RequestMapping(method=RequestMethod.GET, path="type/{type}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> topRated(@PathVariable("type") String type){
		return service.topRated(type);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, path="freeText/{freeText}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> freeText(@PathVariable("freeText") String text){
		return service.freeText(text);
		
	}
	

}
