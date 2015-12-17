import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class MergeSortedListsExamplesTest {
	//from http://www.3geeksforgeeks.org/merge-two-sorted-linked-lists/
	@Test
	public void testExample1() {
		 Integer[] part1Array = {5, 10, 15};
	     Integer[] part2Array = {2, 3, 20};
	     List<Integer> part1List = Arrays.asList(part1Array);
	     List<Integer> part2List = Arrays.asList(part2Array);
	     List<Integer> mergedResult = MergeSortedLists.mergeSortedList(part1List, part2List);
	     Integer[] expectedResult = { 2, 3, 5, 10, 15, 20};
	     List<Integer> expectedResultList = Arrays.asList(expectedResult);
	     assertEquals(mergedResult, expectedResultList);
	}
	
	//from https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists
	@Test
	public void testExample2() {
		 Integer[] part1Array = {null, 1, 3, 5, 6};
	     Integer[] part2Array = {null, 2, 4, 7};
	     List<Integer> part1List = Arrays.asList(part1Array);
	     List<Integer> part2List = Arrays.asList(part2Array);
	     List<Integer> mergedResult = MergeSortedLists.mergeSortedList(part1List, part2List);
	     Integer[] expectedResult = {1, 2, 3, 4, 5, 6, 7};
	     List<Integer> expectedResultList = Arrays.asList(expectedResult);
	     assertEquals(mergedResult, expectedResultList);
	}
	
}
