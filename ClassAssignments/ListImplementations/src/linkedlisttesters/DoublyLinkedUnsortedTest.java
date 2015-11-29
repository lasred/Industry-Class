package linkedlisttesters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import doublylinkedlist.LinkedDListUnsorted;

public class DoublyLinkedUnsortedTest {
	private LinkedDListUnsorted<Integer> testUnsorted;
	@Before
	public void setUp() throws Exception {
		testUnsorted = new LinkedDListUnsorted<Integer>();
		testUnsorted.insert(5);
		testUnsorted.insert(71);
		testUnsorted.insert(1);
		testUnsorted.insert(20);
	}

	@Test
	public void testSet() {
		testUnsorted.set(0, 3);
		assertEquals(testUnsorted.get(0).intValue(), 3);
	}
	@Test
	public void testGetIndex() {
		assertEquals(testUnsorted.get(2).intValue(), 1);
		assertEquals(testUnsorted.get(1).intValue(), 71);
	}
	
	@Test 
	public void testInvalidRemove() {
	   testUnsorted.remove(4);
	   //make sure nothing has been changed
	   assertEquals(4, testUnsorted.getSize());
	}
	
	@Test
	public void testValidRemove() {
		testUnsorted.remove(71);
		assertEquals(3, testUnsorted.getSize());
		assertEquals(testUnsorted.get(1).intValue(), 1);
	}
	
	@Test
	public void testNotContains() {
		assertFalse(testUnsorted.contains(100));
	}
	@Test
	public void testContains() {
		assertTrue(testUnsorted.contains(5));
	}

	@Test
	public void testInsert() {
		testUnsorted.insert(6);
		assertEquals(testUnsorted.get(4).intValue(), 6);
	}

	@Test
	public void testInsertFront() {
		testUnsorted.insertFront(45);
		assertEquals(testUnsorted.getSize(), 5);
		assertEquals(testUnsorted.get(0).intValue(), 45);
	}

}
