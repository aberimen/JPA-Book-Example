package com.aberimen.Repository;

import java.util.List;

import com.aberimen.Model.Customer;

public interface CustomerRepository {
	
	List<Customer> getAll();
	
	Customer findByID(int id);
	
	boolean save(Customer customer);
	
	boolean delete(Customer customer);
	
	boolean update(Customer customer);

}
