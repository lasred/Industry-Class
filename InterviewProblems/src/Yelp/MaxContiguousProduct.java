
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
}
