import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class MergeSortedListsExamplesTest {
	//from http://www.3geeksforgeeks.org/merge-two-sorted-linked-lists/
	@Test
	public void testExample1() {
		 Integer[] part1Array = { 10, 15};
	     Integer[] part2Array = { 3, 20};
	     List<Integer> part1List = Arrays.asList(part1Array);
	     List<Integer> part2List = Arrays.asList(part2Array);
	     List<Integer> mergedResult = MergeSortedLists.mergeSortedList(part1List, part2List);
	     Integer[] expectedResult = {3, 10, 15, 20};
	     List<Integer> expectedResultList = Arrays.asList(expectedResult);
	     assertEquals(mergedResult, expectedResultList);
	}
}
