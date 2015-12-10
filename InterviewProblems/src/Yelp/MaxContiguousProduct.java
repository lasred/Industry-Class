
public class MaxContiguousProduct {
	 public static int maxProduct(int[] sequence) {
		 int start = sequence[0];
	     int max = start;
	     int hN = start > 0? -1: start;
	     int hP = start > 0? start:1;
	     for(int i=1;i<sequence.length;i++) {
	    	 int eval = sequence[i];
	         if(eval > 0) {
	        	 hP = hP * eval;
	             hN = hN * eval;
	         } else if(eval == 0) {
	             hP = 1;
	             hN = -1;
	         } else {
	             int tempHp = hP;
	             hP = hN == -1? 1: hN * eval;
	             hN = tempHp * eval;
	         }
	         if(hP > max) { 
	        	 max = hP;
	         }
	     }
	     return max;
	}
	    
	 public static void main(String[] args) {
		 int[] testSequence1 = {2, 4, 6};
	     System.out.println("test case 1: " + maxProduct(testSequence1)); //2 * 4 * 6 = 48
	     int[] testSequence2 = {2, -4}; //should be 2
	     System.out.println("test case 2: " + maxProduct(testSequence2));
	     int[] testSequence3 = {-4, 2}; //should be 2
	     System.out.println("test case 3: " + maxProduct(testSequence3));
	     int[] testSequence4 = {-6, -5, -9}; //should be 45
	     System.out.println("test case 4: " + maxProduct(testSequence4));
	     int[] testSequence5 = {-10, 0, 2}; //should be 2
	     System.out.println("test case 5: " + maxProduct(testSequence5));
	     int[] testSequence6 = {6, -3, -10, 0, 179}; //should be 180
	     System.out.println("test case 6: " + maxProduct(testSequence6));
	     int[] testSequence7 = {-1, -3, -10, 0, 60}; //should be 60
	     System.out.println("test case 7: " + maxProduct(testSequence7));
	     int[] testSequence8 = {-2, -3, 0, -2, -40}; //should be 80
	     System.out.println("test case 8: " + maxProduct(testSequence8));
	 }
}
