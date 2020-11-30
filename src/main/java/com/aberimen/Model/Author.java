package com.aberimen.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorID;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy = "author")
	private List<Book> books;


	public Author(String firtName, String lastName) {
		this.firstName = firtName;
		this.lastName = lastName;
	}
	
	public Author() {
	}

	public String getFirtName() {
		return firstName;
	}

	public void setFirtName(String firtName) {
		this.firstName = firtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	@Override
	public String toString() {
		return "Author [authorID=" + authorID + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
