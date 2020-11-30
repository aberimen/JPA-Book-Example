package com.aberimen.Repository;

import java.util.List;

import com.aberimen.Model.Book;

public interface BookRepository {

	List<Book> getAllBooks();

	Book findById(int id);
	
	List<Book> getByTitleLike(String title);

	boolean save(Book book);
	
	boolean delete(Book book);
	
	boolean update(Book book);
	

}
