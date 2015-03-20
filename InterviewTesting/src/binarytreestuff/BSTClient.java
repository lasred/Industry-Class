package binarytreestuff;

import java.util.List;
import java.util.Scanner;

public class BSTClient {
	public static void main(String[] args) {
		 Scanner console = new Scanner(System.in);
	     IntTree numbers = new IntTree();
	     System.out.print("Next int (0 to quit)? ");
	     int number = console.nextInt();
	     while (number != 0) {
	         numbers.add(number);
	         System.out.print("Next int (0 to quit)? ");
	         number = console.nextInt();
	     }
	     List<Integer> largestPath = numbers.largestSumFromRootPath();
	     int sum = 0;
	     for(int i=0;i<largestPath.size();i++) {
	    	 sum += largestPath.get(i);
	     }
	     numbers.printPostOrder();
//	     System.out.println("The path to the largest sum is " + largestPath +" and the "
//	     		+ "largest sum is actually " + sum);
//	     numbers.secondLargest());
	   
	}
}
