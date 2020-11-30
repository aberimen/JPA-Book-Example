package com.aberimen.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderID;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	private Date orderDate;
	
	private String shippedDate;
	
	private String shipCity;
	private String shipAddress;
	
	public Order(Customer customer, Book book, Date orderDate, String shipCity, String shipAddress) {
		this.customer = customer;
		this.book = book;
		this.orderDate = orderDate;
		this.shipCity = shipCity;
		this.shipAddress = shipAddress;
	}
	
	public Order() {
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(String shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customer=" + customer + ", book=" + book + ", orderDate=" + orderDate
				+ ", shippedDate=" + shippedDate + ", shipCity=" + shipCity + ", shipAddress=" + shipAddress + "]";
	}
	
	
	

	

}
