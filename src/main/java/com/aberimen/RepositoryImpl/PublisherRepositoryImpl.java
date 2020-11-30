package com.aberimen.RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.aberimen.JpaFactory.JpaFactory;
import com.aberimen.JpaFactoryImp.JpaFactoryImp;
import com.aberimen.Model.Publisher;
import com.aberimen.Repository.PublisherRepository;

public class PublisherRepositoryImpl implements PublisherRepository{

	JpaFactory factory = new JpaFactoryImp();
	EntityManager entityManager = factory.getEntityManager();
	
	@Override
	public List<Publisher> getAll() {
		TypedQuery<Publisher> query = entityManager.createQuery("SELECT p FROM Publisher p",Publisher.class);
		
		return query.getResultList();	
	}

	@Override
	public Publisher findByID(int id) {
		TypedQuery<Publisher> query = entityManager.createQuery("SELECT p FROM Publisher p WHERE p.publisherID = :id",Publisher.class)
				.setParameter("id", id);
		
		return query.getSingleResult();
	}

	@Override
	public boolean save(Publisher publisher) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(publisher);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Publisher publisher) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(publisher);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Publisher publisher) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(publisher);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}
