package linkedlisttesters;

import static org.junit.Assert.*;
import mysinglelinkedlist.LinkedListSorted;

import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListSortedTest {
	private LinkedListSorted<String> sortedList;
	
	@Before
	public void setUp() throws Exception {
		sortedList = new LinkedListSorted<String>();
		sortedList.insert("Tom");
		sortedList.insert("Brady");
		sortedList.insert("Edelman");
	}

	@Test(expected = IllegalArgumentException.class) 
	public void testIllegalInsertOneFromEnd() {
		sortedList.insertAtIndex(2, "Amendola");
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testIllegalInsertEnd() {
		sortedList.insertAtIndex(3, "Arrington");
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testIllegalInsertBegin() {
		sortedList.insertAtIndex(0, "Russell");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalSetBegin() {
		sortedList.set(0, "Gronkowski");
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testIllegalSetEnd() {
		sortedList.set(sortedList.getSize() -1 , "Amendola");
	}
	
	@Test 
	public void testLegalSet() {
		sortedList.set(0, "Amendola");
		assertEquals("Amendola", sortedList.get(0));
	}
	
	@Test
	public void testInsert() {
		assertEquals(sortedList.getSize(), 3);
		assertEquals(sortedList.get(0), "Brady");
	}

	@Test
	public void legalInsertFront() {
		sortedList.insertFront("Amendola");
		assertEquals(sortedList.get(0), "Amendola");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalInsertFrontE() {
		sortedList.insertFront("Russell Wilson");
	}
}
