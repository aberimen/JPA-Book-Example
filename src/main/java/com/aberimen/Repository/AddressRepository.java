package com.aberimen.Repository;

import java.util.List;

import com.aberimen.Model.Address;

public interface AddressRepository {
	
	List<Address> getAll();
	
	Address findByID(int id);
	
	boolean save(Address address);
	
	boolean delete(Address address);
	
	boolean update(Address address);

}
