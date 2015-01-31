package indeedquestions;
/*
 * but sth like if you are given a very large sorted int array then check 
 * of there exists a pair whose sum is equal to the
 *  two parameters a and b passed to the function.
 *  Then he asked if there's an optimal method O(1) to
 *   find the match for the previous question? 
 *   
 *   String - reverse - omptimize
 *    html entity - &hi,
 *    &chris; hi
 *    return ih &chris
 *    &hi; my &name; is
 */
public class SumIn {
	public static void main(String[] args) {
		int[] numbers = {3, 4, 7, 60, 70};
		System.out.println("sum of 3 and 4 exists : " + sumOfTwoExists(numbers, 3, 4) );
		System.out.println("sum of 4 and 5 exists : " + sumOfTwoExists(numbers, 4, 5) );
		String s = "Jasmine";
		System.out.println(s.substring(6));
	}
	
	public static int sumOfTwoExists(int[] largeArray, int a, int b) {
		A: for(int count = 0; count < largeArray.length; count ++) {
			for(int counter = count + 1; counter < largeArray.length; counter ++) {
				if(largeArray[count] + largeArray[counter] == a + b) {
					return 1;
				} else if(largeArray[count] + largeArray[counter] > a + b) {
					break A;
				}
			}
		}
		return -1;
	}
	
}
