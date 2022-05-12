package com.skillsoft.mocks;

import java.util.List;

public interface BookRepository {

	Book getBook(String id);
	List<Book> getBooks(String query);
	
	void addBook(Book book);
	
	void updateBook(Book book);
	
	void deleteBook(String id);
}
