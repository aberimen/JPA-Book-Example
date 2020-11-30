package com.aberimen.Repository;

import java.util.List;

import com.aberimen.Model.Publisher;

public interface PublisherRepository {
	
	List<Publisher> getAll();
	
	Publisher findByID(int id);
	
	boolean save(Publisher publisher);
	
	boolean delete(Publisher publisher);
	
	boolean update(Publisher publisher);
	

}
