package com.aberimen.JpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public interface JpaFactory {
	
	EntityManagerFactory getEntityManagerFactory();
	EntityManager getEntityManager();

}
