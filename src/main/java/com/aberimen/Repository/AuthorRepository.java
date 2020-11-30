package com.aberimen.Repository;

import java.util.List;

import com.aberimen.Model.Author;

public interface AuthorRepository {
	
	List<Author> getAll();
	
	Author findByID(int id);
	
	List<Author> getAuthorByFirstNameLike(String keyword);
	
	boolean save(Author author);
	
	boolean delete(Author author);
	
	boolean update(Author author);

}
