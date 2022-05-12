package com.skillsoft.mocks;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
/* Throwing Exceptions from Stubbed Methods */
	
	@Mock
	private BookRepository bookRepositoryMock;
	
	@InjectMocks
	private BookService bookService;
	
	@Test
	public void testGetBooks() throws BookNotFoundException {
		
		when(bookRepositoryMock.getBook(anyString()))
		         .thenThrow(new BookNotFoundException("Book with this id was not found"));
		
		assertNull(bookService.getBook("asd123"));
	}
}
