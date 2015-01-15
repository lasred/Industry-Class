package linkedliststuff;
import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedIntListTest {
	@Test 
	public void testSumToReverse() {
		LinkedIntList list = new LinkedIntList();
		list.add(7);
		list.add(1);
		list.add(6);
		LinkedIntList list2 = new LinkedIntList();
		list2.add(5);
		list2.add(9);
		list2.add(2);
		LinkedIntList resultList = LinkedIntList.sumToReverse(list, list2);
		String expectedRep = "[2, 1, 9]";
		assertEquals(expectedRep, resultList.toString());

	}
	
}
