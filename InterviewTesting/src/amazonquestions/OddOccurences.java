package amazonquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OddOccurences {
	/**
	 * find all numbers that occurred an odd number of times in an array
	 * @param array
	 * @return
	 */
	public static Set<Integer> allOdd(int[] array) {
//		Map<Integer, Integer> allCounts = new HashMap<Integer, Integer>();
//		for(int c=0;c<array.length; c++) {
//			int toProcess = array[c];
//			if(allCounts.containsKey(toProcess)) {
//				allCounts.put(toProcess, allCounts.get(toProcess) + 1);
//			} else {
//				allCounts.put(toProcess, 1);
//			}
//		}
//		Set<Integer> set = allCounts.keySet();
//		Iterator<Integer> iterate = set.iterator();
//		while(iterate.hasNext()) {
//			int key = iterate.next();
//			if(allCounts.get(key) % 2 == 0)
//				iterate.remove();
//		}
//		return allCounts.keySet();
		Set<Integer> set = new HashSet<Integer>();
		//on off pattern
		for(int c=0;c<array.length;c++) {
			int toProcess = array[c];
			if(set.contains(toProcess)) {
				set.remove(toProcess);
			} else {
				set.add(toProcess);
			}
		}
		return set;
	} 
	public static void main(String[] args){
		int[] testCase1 = {2,3,2,4,4,4,6,8,8};
		int[] testCase2 = {90,91,91,93,93,93,95,98,98,97};
		int[] testCase3 = {30,30,31,31,31,35,23,23,23,23,1};
		System.out.println(allOdd(testCase1).toString());
		System.out.println(allOdd(testCase2).toString());
		System.out.println(allOdd(testCase3).toString());


	}
} 
