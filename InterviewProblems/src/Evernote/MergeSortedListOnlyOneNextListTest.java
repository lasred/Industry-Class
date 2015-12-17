import static org.junit.Assert.*;

import java.util.List;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;


public class MergeSortedListOnlyOneNextListTest {
	
	private static List<Integer> hasNoNextList;
	private static List<Integer> hasNextList;
	private static List<Integer> resultList;
	
	@BeforeClass 
	public static void initializeTestLists() {
		Integer[] hasNext =  {1, 2, 3, 30};
		Integer[] hasNoNext =  {25};
		hasNextList = Arrays.asList(hasNext);
		hasNoNextList = Arrays.asList(hasNoNext);
		Integer[] result = {1, 2, 3, 25, 30};
		resultList = Arrays.asList(result);
	}
	
	@Test
	public void testList1OnlyHasNext() {
	    List<Integer> mergedResult = MergeSortedLists.mergeSortedList(hasNextList, hasNoNextList);
	    assertEquals(mergedResult, resultList);
	}

	@Test
	public void testList2OnlyHasNext() {
	    List<Integer> mergedResult = MergeSortedLists.mergeSortedList(hasNoNextList,hasNextList);
	    assertEquals(mergedResult, resultList);
	}
}
