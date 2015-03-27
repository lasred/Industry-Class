package pivotallabs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetTest {
	private Set set;
	@Before
	public void setUp() throws Exception {
		set = new Set();
	}
	@Test
	public void testNonExistentRemove() {
		for(int c =100;c<109;c++) {
			set.insert(c);
		}
		for(int nonE=8;nonE<20;nonE++){
			set.remove(nonE);
		}
		assertEquals(set.getSize(), 9);
	}
	@Test
	public void  testRemove() {
		for(int c =0;c<5;c++) {
			set.insert(c);
		}
		set.remove(3);
		assertEquals(4, set.getSize());
		assertFalse(set.contains(3));
	}
	
	@Test
	public void testInsertDuplicate() {
		for(int c=0;c<10; c++) {
			set.insert(4);
		}
		assertEquals(set.getSize(), 1);
	}
	@Test
	public void testIsEmpty() {
		assertTrue(set.isEmpty());
	}
	
	@Test
	public void testBasicInsert() {
		set.insert(5);
		set.insert(4);
		assertEquals(2, set.getSize());
		assertTrue(set.contains(5) && set.contains(4));
	}

}
