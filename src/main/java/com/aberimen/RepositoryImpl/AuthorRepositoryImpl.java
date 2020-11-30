package com.aberimen.RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.aberimen.JpaFactory.JpaFactory;
import com.aberimen.JpaFactoryImp.JpaFactoryImp;
import com.aberimen.Model.Author;
import com.aberimen.Repository.AuthorRepository;

public class AuthorRepositoryImpl implements AuthorRepository {

	JpaFactory factory = new JpaFactoryImp();
	EntityManager entityManager = factory.getEntityManager();

	@Override
	public List<Author> getAll() {
		TypedQuery<Author> query = entityManager.createQuery("SELECT a FROM Author a", Author.class);
		
		return query.getResultList();
	}

	@Override
	public List<Author> getAuthorByFirstNameLike(String keyword) {
		return entityManager.createQuery("SELECT a FROM Author a WHERE a.firstName LIKE :keyword", Author.class)
				.setParameter("keyword", "%" + keyword + "%")
				.getResultList();
	}

	@Override
	public boolean save(Author author) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(author);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Author findByID(int id) {
		TypedQuery<Author> query = entityManager.createQuery("SELECT a FROM Author a WHERE a.authorID = :id",Author.class)
				.setParameter("id", id);
		
		return query.getSingleResult();
	}


	@Override
	public boolean delete(Author author) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(author);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	

	@Override
	public boolean update(Author author) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(author);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
}