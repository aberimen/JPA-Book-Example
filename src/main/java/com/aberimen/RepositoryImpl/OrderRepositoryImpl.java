package com.aberimen.RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.aberimen.JpaFactory.JpaFactory;
import com.aberimen.JpaFactoryImp.JpaFactoryImp;
import com.aberimen.Model.Order;
import com.aberimen.Repository.OrderRepository;

public class OrderRepositoryImpl implements OrderRepository{
	
	JpaFactory factory = new JpaFactoryImp();
	EntityManager entityManager = factory.getEntityManager();

	@Override
	public List<Order> getAll() {
		TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o",Order.class);
		
		return query.getResultList();
	}

	@Override
	public Order findByID(int id) {
		TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o WHERE o.orderID = :id",Order.class)
				.setParameter("id", id);
		
		return query.getSingleResult();
	}

	@Override
	public boolean save(Order order) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(order);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Order order) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(order);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Order order) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(order);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}
