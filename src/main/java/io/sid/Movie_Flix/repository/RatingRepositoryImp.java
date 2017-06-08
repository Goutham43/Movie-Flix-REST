package io.sid.Movie_Flix.repository;

import io.sid.Movie_Flix.entity.Movie;
import io.sid.Movie_Flix.entity.Rating;
import io.sid.Movie_Flix.entity.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class RatingRepositoryImp implements RatingRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Rating> findAll(Movie movie) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findAll", Rating.class);
		query.setParameter("pMovie", movie);
		return query.getResultList(); 
	
	}

	@Override
	public Rating findOne(String id) {
		
		return em.find(Rating.class, id);
			
	}
	
	
	@Override
	public Rating create(Rating rating) {
		
		em.persist(rating);	
		return rating;
		
	}

	@Override
	public void delete(Rating rating) {
		
		em.remove(rating);
		
	}

}
