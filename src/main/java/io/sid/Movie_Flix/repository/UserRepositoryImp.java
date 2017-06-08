package io.sid.Movie_Flix.repository;

import io.sid.Movie_Flix.entity.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImp implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAll() {
		
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String id) { 
		
		return em.find(User.class, id);
	}
	
	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> users = query.getResultList();
		if(users!=null && users.size()==1){
			return users.get(0);
		}
		return null;
	}
	
	@Override
	public User create(User user) {
		
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
	
		em.remove(user);
	}

	@Override
	public User findByEmailPass(String email, String password) {
		
		TypedQuery<User> query = em.createNamedQuery("User.findByEmailPass",User.class);
		query.setParameter("pEmail", email);
		query.setParameter("pPassword", password);
		List<User> users = query.getResultList();
		if(users!=null && users.size()==1){
			return users.get(0);
		}
		return null;
	
	}

}
