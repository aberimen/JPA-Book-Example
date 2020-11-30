package com.aberimen.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String addresName;
	private String adress;
	private String district;
	private String region;
	private String city;

	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;


	public Address(String addresName, String adress, String district, String region, String city, Customer customer) {
		this.addresName = addresName;
		this.adress = adress;
		this.district = district;
		this.region = region;
		this.city = city;
		this.customer = customer;
	}
	
	public Address() {
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAddresName() {
		return addresName;
	}


	public void setAddresName(String addresName) {
		this.addresName = addresName;
	}


	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
