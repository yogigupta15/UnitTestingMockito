package com.skillsoft.mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import java.util.Comparator;
import java.util.TreeSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class TreeSetTest {
	
	/* Using the @Mock Annotation to create Mocks */
	
	@Mock
	private Comparator<String> comparatorMock;
	
	private AutoCloseable closeable;
	
	@BeforeEach
	public void initilizeMocks() {
		
		closeable = openMocks(this);
		
		when(comparatorMock.compare("Alice", "Bob")).thenReturn(1);
		when(comparatorMock.compare("Bob", "Alice")).thenReturn(1);
		when(comparatorMock.compare("Alice", "Charles")).thenReturn(1);
		
		when(comparatorMock.compare("Bob", "Alice")).thenReturn(-1);
		when(comparatorMock.compare("Charles", "Bob")).thenReturn(-1);
		when(comparatorMock.compare("Charles", "Alice")).thenReturn(-1);
		
		when(comparatorMock.compare("Alice", "Alice")).thenReturn(0);
		when(comparatorMock.compare("Bob", "Bob")).thenReturn(0);
		when(comparatorMock.compare("Charles", "Charles")).thenReturn(0);	
	}
	
	@AfterEach
	public void releaseMocks() throws Exception{
		closeable.close();
	}
	
	@Test
	public void testTreeSet() {
		
		TreeSet<String> treeSet = new TreeSet<>(comparatorMock);
		
		treeSet.add("Bob");
		treeSet.add("Alice");
        treeSet.add("Charles");
        
        assertEquals("Charles", treeSet.first());
        assertEquals("Alice", treeSet.last());
        
        assertEquals("Bob", treeSet.higher("Charles"));
        assertEquals("Bob", treeSet.lower("Alice"));	
	}
}
