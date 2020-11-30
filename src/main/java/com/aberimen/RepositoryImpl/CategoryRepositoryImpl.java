package com.aberimen.RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.aberimen.JpaFactory.JpaFactory;
import com.aberimen.JpaFactoryImp.JpaFactoryImp;
import com.aberimen.Model.Category;
import com.aberimen.Repository.CategoryRepository;

public class CategoryRepositoryImpl implements CategoryRepository{
	JpaFactory factory = new JpaFactoryImp();
	EntityManager entityManager = factory.getEntityManager();

	@Override
	public List<Category> getAll() {
		TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c",Category.class);
		
		return query.getResultList();	
	}

	@Override
	public Category findByID(int id) {
		TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c WHERE c.categoryID = :id",Category.class)
				.setParameter("id", id);
		
		return query.getSingleResult();	
	}

	@Override
	public boolean save(Category category) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(category);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Category category) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(category);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Category category) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(category);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}
