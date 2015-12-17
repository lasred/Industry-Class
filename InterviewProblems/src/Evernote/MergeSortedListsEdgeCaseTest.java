import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MergeSortedListsEdgeCaseTest {

	@Test
	public void testBothIteratorsNoNext() {
		 Integer[] part1Array = {9};
	     Integer[] part2Array = {3};
	     List<Integer> part1List = Arrays.asList(part1Array);
	     List<Integer> part2List = Arrays.asList(part2Array);
	     List<Integer> mergedResult = MergeSortedLists.mergeSortedList(part1List, part2List);
	     Integer[] expectedResult = {3, 9};
	     List<Integer> expectedResultList = Arrays.asList(expectedResult);
	     assertEquals(mergedResult, expectedResultList);
	}
	
	@Test
	public void testNullInFront() {
		 Integer[] part1Array = {null, null, 9};
	     Integer[] part2Array = {null, 3};
	     List<Integer> part1List = Arrays.asList(part1Array);
	     List<Integer> part2List = Arrays.asList(part2Array);
	     List<Integer> mergedResult = MergeSortedLists.mergeSortedList(part1List, part2List);
	     Integer[] expectedResult = {3, 9};
	     List<Integer> expectedResultList = Arrays.asList(expectedResult);
	     assertEquals(mergedResult, expectedResultList);
	}
	
	
}
