package arraylisttesters;

import static org.junit.Assert.*;
import myarraylist.ArrayListSorted;

import org.junit.Before;
import org.junit.Test;

public class ArrayListSortedTest {
	private ArrayListSorted<String> toTestString;
	private ArrayListSorted<Integer> toTestInteger;
	
	@Before
	public void setUp() {
		toTestString = new ArrayListSorted<String>();
		toTestInteger = new ArrayListSorted<Integer>();
		toTestInteger.insert(6);
		toTestInteger.insert(4);
		toTestInteger.insert(2);
	}
	
	@Test
	public void testGet() {
		toTestInteger.clear();
		for(int count = 0; count < 100; count ++) {
			toTestInteger.insert(count);
		}
		assertEquals(toTestInteger.getIndex(45), 45);
		assertEquals(toTestInteger.getIndex(89), 89);

	}
	@Test(expected = IllegalArgumentException.class) 
	public void testImproperSet(){
		toTestInteger.set(0, 10);
	}
	
	@Test
	public void testProperSets() {
		toTestInteger.set(1, 5);
		assertEquals(toTestInteger.get(1).intValue(), 5);
		toTestInteger.set(0, 3);
		assertEquals(toTestInteger.get(0).intValue(), 3);

	}
	
	@Test
	public void testRemove() {
		toTestInteger.removeAtIndex(0);
		//make sure everything gets shifted
		assertEquals(toTestInteger.get(0).intValue(), 4);
		assertEquals(toTestInteger.get(1).intValue(), 6);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testImproperInsertion(){
		toTestInteger.insertAtIndex(2, 1);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testImproperInsertion2(){
		toTestInteger.insertAtIndex(1, 5);
	}
	
	@Test
	public void testSortedIntegerInsert() {
		assertEquals(toTestInteger.get(0).intValue(), 2);
	}
	
	@Test
	public void testSortedStringInsert() {
		toTestString.insert("Marshawn");
		toTestString.insert("Lynch");
		toTestString.insert("Beast Mode");
		assertEquals(toTestString.get(0), "Beast Mode");
	}
	
	
	

}
