package com.aberimen.JpaFactoryImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.aberimen.JpaFactory.JpaFactory;

public class JpaFactoryImp implements JpaFactory{
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}

	@Override
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
