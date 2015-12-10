import static org.junit.Assert.*;

import org.junit.Test;


public class MaxContiguousProductTest {

	@Test
	public void testAllPositives() {
		int[] testSequence = {2, 4, 6};
	    assertEquals(48, MaxContiguousProduct.maxProduct(testSequence));
	}
	
	@Test
	public void testAlternatePositiveNegative() {
		int[] testSequence = {2, -4};
	    assertEquals(2, MaxContiguousProduct.maxProduct(testSequence));
	}
	
	@Test
	public void testAlternateNegativePositive() {
		int[] testSequence = {-4, 2}; 
		assertEquals(2, MaxContiguousProduct.maxProduct(testSequence));
		int[] testSequence2 = {-10, 0, 2}; 
	    assertEquals(2, MaxContiguousProduct.maxProduct(testSequence2));
	}
	
	@Test
	public void testAllNegatives() {
		//array, pass by reference 
		int[] testSequence = {-6, -5, -9}; 
		assertEquals(45, MaxContiguousProduct.maxProduct(testSequence));
	}
	
	//from http://www.geeksforgeeks.org/maximum-product-subarray/
	@Test
	public void testStandardListedTestCases() {
		int[] testSequence = {6, -3, -10, 0, 179}; 
		assertEquals(180, MaxContiguousProduct.maxProduct(testSequence));
		int[] testSequence2 = {-1, -3, -10, 0, 60}; 
		assertEquals(60, MaxContiguousProduct.maxProduct(testSequence2));
		int[] testSequence3 = {-2, -3, 0, -2, -40};
		assertEquals(80, MaxContiguousProduct.maxProduct(testSequence3));
	}
}
