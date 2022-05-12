package com.skillsoft.mocks;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
/* Stubbing Methods to Throw Exceptions */
	
	@Mock
	private BookRepository bookRepositoryMock;
	
	@InjectMocks
	private BookService bookService;
	
	@Test
	public void testGetBooks() {
		
		when(bookRepositoryMock.getBook(anyString()))
		         .thenThrow(new IllegalArgumentException("Wrongly formed id"));
		
		try {
			Book book = bookService.getBook("asd123");
			
			fail();
			
		}catch(Exception ex) {
			
			assertTrue(ex instanceof IllegalArgumentException);
			assertEquals("Wrongly formed id", ex.getMessage());
		}
	}
}
