package com.aberimen.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookID;
	private String ISBN;
	private String title;
	private int totalPages;
	
	private LocalDate publishedDate;
	
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "publsiher_id")
	private Publisher publisher;
	
	
	//Constructors, getters and setters
	
	
	
	public Book(String ISBN, String title, int totalPages, LocalDate publishedDate, double price, Author author,
			Category category, Publisher publisher) {
		this.ISBN = ISBN;
		this.title = title;
		this.totalPages = totalPages;
		this.publishedDate = publishedDate;
		this.price = price;
		this.author = author;
		this.category = category;
		this.publisher = publisher;
	}
	
	public Book() {
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", ISBN=" + ISBN + ", title=" + title + ", totalPages=" + totalPages
				+ ", publishedDate=" + publishedDate + ", price=" + price + ", author=" + author + ", category="
				+ category + ", publisher=" + publisher + "]";
	}
	


}
