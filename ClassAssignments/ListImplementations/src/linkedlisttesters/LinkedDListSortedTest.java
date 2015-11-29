package linkedlisttesters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import doublylinkedlist.LinkedDListSorted;

public class LinkedDListSortedTest {
	private LinkedDListSorted<String> doublySortedTest;
	@Before
	public void setUp() throws Exception {
		doublySortedTest = new LinkedDListSorted<String>();
		doublySortedTest.insert("Revis");
		doublySortedTest.insert("Amendola");
		doublySortedTest.insert("Brady");
	}

	@Test
	public void testInsert() {
		assertEquals(3, doublySortedTest.getSize());
		assertEquals(doublySortedTest.get(1), "Brady");
		assertEquals(doublySortedTest.get(0), "Amendola");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInsertFrontInvalid() {
		doublySortedTest.insertFront("Wilfork");
	}
	
	@Test
	public void testInsertFront() {
		doublySortedTest.insertFront("Aaron Rodgers");
		assertEquals("Aaron Rodgers" , doublySortedTest.get(0));
	}
	
	
	@Test
	public void testRemoveAtIndex() {
		doublySortedTest.removeAtIndex(1);
		assertEquals(doublySortedTest.get(1), "Revis");
		assertEquals(2, doublySortedTest.getSize());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInsertAtIndexInvalid() {
		doublySortedTest.insertAtIndex(doublySortedTest.getSize() - 1, "Aaron Rodgers");
	}
	
	@Test
	public void testInsertAtIndexValid() {
		doublySortedTest.insertAtIndex(1, "Brad Pitt");
		assertEquals("Brad Pitt", doublySortedTest.get(1));
		assertEquals(4, doublySortedTest.getSize());
	}

}
