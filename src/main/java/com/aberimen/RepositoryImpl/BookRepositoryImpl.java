package com.aberimen.RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.aberimen.JpaFactory.JpaFactory;
import com.aberimen.JpaFactoryImp.JpaFactoryImp;
import com.aberimen.Model.Book;
import com.aberimen.Repository.BookRepository;

public class BookRepositoryImpl implements BookRepository{
	
	JpaFactory factory = new JpaFactoryImp();
	EntityManager entityManager = factory.getEntityManager();

	@Override
	public List<Book> getAllBooks() {
		TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b",Book.class);
		
		return query.getResultList();
	}

	@Override
	public Book findById(int id) {
		TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.bookID = :id",Book.class);
		Book book = query.setParameter("id", id)
				.getSingleResult();
		
		return book;
	}

	@Override
	public boolean save(Book book) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(book);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Book> getByTitleLike(String title) {
		TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.title LIKE :title",Book.class)
				.setParameter("title", title);
		
		return query.getResultList();			
	}

	@Override
	public boolean delete(Book book) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(book);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Book book) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(book);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}
