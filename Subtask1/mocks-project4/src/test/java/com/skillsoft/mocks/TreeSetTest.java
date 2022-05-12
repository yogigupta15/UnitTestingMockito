package com.skillsoft.mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreeSetTest {
	
	private Comparator<String> comparatorMock;
	
	@BeforeEach
	public void setupMocks() {
		
		comparatorMock = mock(Comparator.class);
		
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
	public void releaseMocks() {
		comparatorMock = null;
	}
	
	@Test
	public void testTreeSet() {
		
		TreeSet<String> treeSet = new TreeSet<>(comparatorMock);
		
		treeSet.add("Bob");
		treeSet.add("Alice");
        treeSet.add("Charles");
		
//		treeSet.add("Yasmin");
//		treeSet.add("Xavier");
//		treeSet.add("Zeo");
		
		for(String element : treeSet) {
			System.out.println(element);
		}
	}
	
	@Test
	public void testTreeSet1() {
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
