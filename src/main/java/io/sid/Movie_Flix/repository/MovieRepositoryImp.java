package io.sid.Movie_Flix.repository;

import io.sid.Movie_Flix.entity.Movie;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepositoryImp implements MovieRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> findAll() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll",Movie.class);
		return query.getResultList();
		 
	}

	@Override
	public Movie findOne(String id) {
		
		 return em.find(Movie.class, id);
	
	}
	
	@Override
	public Movie findByTitle(String title) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movies = query.getResultList();
		if(movies!=null && movies.size()==1){
			return movies.get(0);
		}
		return null;
		
	}

	@Override
	public Movie create(Movie movie) {
		
		em.persist(movie);
		return movie;
		
	}

	@Override
	public Movie update(Movie movie) {
		
		return em.merge(movie);
		
	}

	@Override
	public void delete(Movie movie) {
		
		em.remove(movie);
		
	}

	@Override
	public List<Movie> sortByIMDBRatings() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByIMDBRatings", Movie.class);
		return query.getResultList();
	
	}

	@Override
	public List<Movie> sortByYear() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByYear", Movie.class);
		return query.getResultList();
		
	}

	@Override
	public List<Movie> sortByIMDBVotes() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByIMDBVotes", Movie.class);
		return query.getResultList();
		
	}

	@Override
	public List<Movie> topRated(String type) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.topRated", Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();
		
	}

	@Override
	public List<Movie> freeText(String text) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.freeText", Movie.class);
		query.setParameter("pFreeText", "%"+text+"%");
		return query.getResultList();
	}

}
