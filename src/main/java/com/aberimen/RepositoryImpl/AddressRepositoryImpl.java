package com.aberimen.RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.aberimen.JpaFactory.JpaFactory;
import com.aberimen.JpaFactoryImp.JpaFactoryImp;
import com.aberimen.Model.Address;
import com.aberimen.Repository.AddressRepository;

public class AddressRepositoryImpl implements AddressRepository {
	
	
	JpaFactory factory = new JpaFactoryImp();
	EntityManager entityManager = factory.getEntityManager();

	@Override
	public List<Address> getAll() {
		TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a", Address.class);
		
		return query.getResultList();
	}

	@Override
	public Address findByID(int id) {
		TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a WHERE a.addressID = :id",Address.class)
				.setParameter("id", id);
		
		return query.getSingleResult();
	}

	@Override
	public boolean save(Address address) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(address);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Address address) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(address);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Address address) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(address);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	


}
