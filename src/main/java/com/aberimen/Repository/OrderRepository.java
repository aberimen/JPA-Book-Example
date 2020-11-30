package com.aberimen.Repository;

import java.util.List;

import com.aberimen.Model.Order;

public interface OrderRepository {

	List<Order> getAll();
	
	Order findByID(int id);
	
	boolean save(Order order);
	
	boolean delete(Order order);
	
	boolean update(Order order);

}
