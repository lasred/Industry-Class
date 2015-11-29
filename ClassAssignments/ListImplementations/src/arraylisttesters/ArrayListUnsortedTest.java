package arraylisttesters;


import static org.junit.Assert.*;
import myarraylist.AbstractArrayMyList;
import myarraylist.ArrayListUnsorted;

import org.junit.Before;
import org.junit.Test;

public class ArrayListUnsortedTest {
	private AbstractArrayMyList<Integer> myList;
	
	@Before
	public void setUp() throws Exception {
		myList = new ArrayListUnsorted<Integer>();
		myList.insert(4);
		myList.insert(5);
	}
	
	@Test
	public void testInsertFront() {
		myList.insertFront(3);
		assertEquals(myList.get(0).intValue(), 3);
		assertEquals(myList.getSize(), 3);
	}
	
	@Test
	public void testSet() {
		myList.set(0, 2);
		assertEquals(myList.get(0).intValue(), 2);
	}

	@Test
	public void testRemove() {
		myList.remove(4);
		assertEquals(myList.get(0).intValue(), 5);
		assertEquals(myList.getSize(), 1);
	}

	@Test
	public void testInsert() {
		assertEquals(myList.getSize(), 2);
	}

	@Test
	public void testGetIndex() {
		assertEquals(myList.get(0).intValue(), 4);
		assertEquals(myList.get(1).intValue(), 5);
	}

	@Test
	public void testRemoveAtIndex() {
		myList.removeAtIndex(0);
		assertEquals(myList.get(0).intValue(), 5);
	}
	
	@Test
	public void testClear() {
		myList.clear();
		assertTrue(myList.isEmpty());
	}
}
