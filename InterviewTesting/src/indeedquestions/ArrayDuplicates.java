package indeedquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * . The second asked for a function that took in two sorted arrays of integers
 *  with no duplicate values within a single array 
 * and which returned an array of the duplicates between the two arrays.
 * @author chris
 *
 */
public class ArrayDuplicates {
	public static void main(String[] args) {
		int[] sorted1 = {1, 2, 3, 5, 7};
		int[] sorted2 = {2, 4, 5, 6};
		Integer[] duplicates = duplicates2(sorted1, sorted2);
		for(Integer d: duplicates) {
			System.out.println(d.intValue());
		}
	}
	public static Integer[] duplicates2(int[] sorted1, int[] sorted2) {
		List<Integer> duplicates = new ArrayList<Integer>();
		int index1, index2;
		index1 = index2 = 0;
		while(index1 < sorted1.length && index2 < sorted2.length){
			if(sorted1[index1] < sorted2[index2]){
				index1++;
			}else if(sorted1[index1] > sorted2[index2]){
				index2++;
			}else{
				duplicates.add(sorted1[index1]);
				index1++;
				 index2++;
			}
		}
		return duplicates.toArray(new Integer[duplicates.size()]);
	}
	public static Integer[] duplicates(int[] sorted1, int[] sorted2) {
		List<Integer> duplicates = new ArrayList<Integer>();
		for(int count = 0; count < sorted1.length; count ++) {
			for(int counter = 0; counter < sorted2.length; counter ++) {
				if(sorted1[count] == sorted2[counter]) {
					duplicates.add(sorted1[count]);
				} else if(sorted1[count] < sorted2[counter]) {
					break;
				}	
			}
		}
		return duplicates.toArray(new Integer[duplicates.size()]);
	}
}
