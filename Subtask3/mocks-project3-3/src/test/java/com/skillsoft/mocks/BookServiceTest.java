package com.skillsoft.mocks;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
/* Throwing Exceptions from Void Methods */
	
	@Mock
	private BookRepository bookRepositoryMock;
	
	@InjectMocks
	private BookService bookService;
	
	@Test
	public void testDeleteBook() throws BookNotFoundException {
		
		doThrow(new BookNotFoundException("Book with this id was not found")).
		        when(bookRepositoryMock).
		        deleteBook(anyString());
		
		try {
			bookService.deleteBook("asd123");
			
			fail();
		}catch(Exception ex) {
			assertTrue(ex instanceof BookNotFoundException);
			assertEquals("Book with this id was not found", ex.getMessage());
		}
	}
}
