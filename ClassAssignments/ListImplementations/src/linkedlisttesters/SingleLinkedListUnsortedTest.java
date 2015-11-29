package linkedlisttesters;

import static org.junit.Assert.*;
import mysinglelinkedlist.LinkedListUnsorted;

import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListUnsortedTest {
	private LinkedListUnsorted<Integer> integers;
	@Before
	public void setUp() {
		integers = new LinkedListUnsorted<Integer>();
		integers.insert(4);
		integers.insert(5);
		integers.insert(6);
	}
	
	@Test 
	public void testContains() {
		assertTrue(integers.contains(4));
	}

	@Test
	public void testInsert() {
		assertEquals(integers.getSize(), 3);
	}

	@Test
	public void testGetIndex() {
		assertEquals(integers.get(0).intValue(), 4);
		assertEquals(integers.get(1).intValue(), 5);
	}

	@Test
	public void testRemove() {
		integers.remove(5);
		assertEquals(integers.getSize(), 2);
		assertEquals(integers.get(1).intValue(), 6);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testOutOfBoundsSet() {
		integers.set(3, 420);
	}
	@Test
	public void testProperSet() {
		integers.set(2, 80);
		assertEquals(integers.get(2).intValue(), 80);
	}
	@Test
	public void testInsertFront() {
		integers.insertFront(20);
		assertEquals(integers.get(0).intValue(), 20);
		assertEquals(integers.getSize(), 4);

	}

	@Test
	public void testClear() {
		integers.clear();
		assertTrue(integers.isEmpty());
	}

}
