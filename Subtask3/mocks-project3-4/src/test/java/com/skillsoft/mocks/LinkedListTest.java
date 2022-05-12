package com.skillsoft.mocks;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.spy;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class LinkedListTest {
	
	/* Creating Partial Mocks Using Spies */
	
	@Test
	public void testLinkedList() {
		
		LinkedList<String> linkedList = new LinkedList<>();
		LinkedList<String> linkedListSpy = spy(linkedList);
		
		linkedListSpy.add("Nora");
		linkedListSpy.add("Fred");
		linkedListSpy.add("Maureen");
		
		System.out.println("Contents of linked list: " + linkedList);
		System.out.println("Contents of linked list spy: " + linkedListSpy);
		
		assertNotEquals(linkedList.size(), linkedListSpy.size());
	}
}
