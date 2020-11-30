package com.aberimen.RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.aberimen.JpaFactory.JpaFactory;
import com.aberimen.JpaFactoryImp.JpaFactoryImp;
import com.aberimen.Model.Customer;
import com.aberimen.Repository.CustomerRepository;

public class CustomerRepositoryImpl implements CustomerRepository{
	
	JpaFactory factory = new JpaFactoryImp();
	EntityManager entityManager = factory.getEntityManager();


	@Override
	public List<Customer> getAll() {
		TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Category c",Customer.class);
				
		return query.getResultList();
	}

	@Override
	public Customer findByID(int id) {
		TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Category c WHERE c.customerID = :id",Customer.class)
				.setParameter("id", id);
		
		return query.getSingleResult();	
	}

	@Override
	public boolean save(Customer customer) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(customer);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Customer customer) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(customer);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Customer customer) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(customer);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}
