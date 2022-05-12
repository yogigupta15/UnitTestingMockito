package com.skillsoft.mocks;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ArrayListMock {
	/* stubbing  method using when(), then() */
	@Test
	public void mockArrayList() {
		
		ArrayList someArrayList = mock(ArrayList.class);
		
		when(someArrayList.isEmpty()).thenReturn(true);
		when(someArrayList.size()).thenReturn(23);
		when(someArrayList.toArray()).thenReturn(new Object[] {1,3,6,9});
		
		assertTrue(someArrayList.isEmpty());
		assertEquals(23, someArrayList.size());
		assertArrayEquals(new Object[] {1,3,6,9}, someArrayList.toArray());
	}
	
}
