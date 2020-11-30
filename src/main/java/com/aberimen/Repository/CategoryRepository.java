package com.aberimen.Repository;

import java.util.List;

import com.aberimen.Model.Category;

public interface CategoryRepository {
	
	List<Category> getAll();
	
	Category findByID(int id);
	
	boolean save(Category category);
	
	boolean delete(Category category);
	
	boolean update(Category category);
	
	


}
