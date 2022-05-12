package com.skillsoft.mocks;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class LinkedListTest {
	
      /* Stubbing individual Methods in spies */
	
	@Spy
	LinkedList<String> linkedListSpy = new LinkedList<>();
	
	AutoCloseable closeable;
	
	@BeforeEach
	public void setupTests() {
		closeable = openMocks(this);
	}
	
	@AfterEach
	public void tearDownTests() throws Exception{
		closeable.close();
	}
	
	@Test
	public void testLinkedList() {
		
		linkedListSpy.add("Nora");
		linkedListSpy.add("Fred");
		linkedListSpy.add("Maureen");
		linkedListSpy.add("Ophelia");
		
		verify(linkedListSpy, times(4)).add(anyString());
		
		assertEquals(4,linkedListSpy.size());
		
		when(linkedListSpy.size()).thenReturn(1001); //this is stubbing
		
		assertEquals(1001, linkedListSpy.size()); 
		
		linkedListSpy.remove("Maureen");
		
		assertEquals(1001, linkedListSpy.size());
	}
	
	@Test
	public void testLinkedList1() {
		
		linkedListSpy.add("Nora");
		linkedListSpy.add("Fred");
		linkedListSpy.add("Maureen");
		linkedListSpy.add("Ophelia");
		
		verify(linkedListSpy, times(4)).add(anyString());
		
		assertEquals(4,linkedListSpy.size());
		
		when(linkedListSpy.remove(anyString())).thenReturn(true); //this is stubbing
		
		linkedListSpy.remove("Nora");
		linkedListSpy.remove("Ophelia");
		
		verify(linkedListSpy, times(2)).remove(anyString());
		
		assertEquals(4, linkedListSpy.size());
	}
}
