package com.aberimen.App;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import com.aberimen.Model.Author;
import com.aberimen.Model.Book;
import com.aberimen.Model.Category;
import com.aberimen.Model.Publisher;
import com.aberimen.Repository.AuthorRepository;
import com.aberimen.Repository.BookRepository;
import com.aberimen.Repository.CategoryRepository;
import com.aberimen.Repository.PublisherRepository;
import com.aberimen.RepositoryImpl.AuthorRepositoryImpl;
import com.aberimen.RepositoryImpl.BookRepositoryImpl;
import com.aberimen.RepositoryImpl.CategoryRepositoryImpl;
import com.aberimen.RepositoryImpl.PublisherRepositoryImpl;


public class App {
	
	public static void main(String[] args) {
		//insertData();
		
		BookRepository bookRepository = new BookRepositoryImpl();
		System.out.println(bookRepository.findById(1).toString());
	}
	
	static void insertData() {
		
		Author author = new Author("Fyodor", "Dostoyevski");
		Author author1 = new Author("George","Orwell");
		
		AuthorRepository authorRepository = new AuthorRepositoryImpl();
		authorRepository.save(author);
		authorRepository.save(author1);
		
		Category category = new Category("Edebiyat");
		Category category1 = new Category("Psikoloji");
		
		CategoryRepository categoryRepository = new CategoryRepositoryImpl();
		categoryRepository.save(category);
		categoryRepository.save(category1);
		
		Publisher publisher = new Publisher("CAN YAYINLARI");
		Publisher publisher1 = new Publisher("TÜRKİYE İŞ BANKASI KÜLTÜR YAYINLARI");
		
		PublisherRepository publisherRepository = new PublisherRepositoryImpl();
		publisherRepository.save(publisher);
		publisherRepository.save(publisher1);
		
		
		
		
		Book book = new Book("9789750718533", "1984", 352, LocalDate.of(2019, 4, 25) , 24.70, author1, category, publisher);
		Book book1 = new Book("9789750739606", "İnsancıklar", 184, LocalDate.of(2019, 6, 8) , 14, author, category, publisher);
		
		BookRepository bookRepository = new BookRepositoryImpl();
		bookRepository.save(book);
		bookRepository.save(book1);
	}
	

}
