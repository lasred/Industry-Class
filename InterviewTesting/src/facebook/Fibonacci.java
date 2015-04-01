package facebook;

public class Fibonacci {
	//all the Fibonacci values you've calculated;
   static int[] fibonacciCalculated = new int[10000]; 
   /*
    * Check if I am returning a valid Fibonacci 
    */
   static void checkFibonacci(int n) {
	   if(n < 0) {
		   throw new IllegalArgumentException();
	   }
   }
   //O(n) space   O(2^n) time
   static int getFibonacciNoCache(int n) {
	   checkFibonacci(n);
		if(n == 0|| n==1) {
			return n;
		}else {
			return getFibonacciNoCache(n-1) + getFibonacciNoCache(n-2);
		}
	}
   //O(n) space O(n)time
	static int getFibonacciCache(int n) {
		checkFibonacci(n);
		if(n== 0 || n == 1) {
			return n;
		} else {
			if(fibonacciCalculated[n] == 0)
				fibonacciCalculated[n] = getFibonacciCache(n-1) + getFibonacciCache(n-2);
			return fibonacciCalculated[n];
		}
	}
	//O(1) space O(n) time
	static int iterativeFibonacci(int n) {
		checkFibonacci(n);
		if(n==0|| n==1) {
			return n;
		} else {
			//know n>=2;
			int sum = 0;
			int firstPrevious = 1;
			int secondPrevious = 0;
			//first time i am doing it, for n=2
			for(int to=1;to<n;to++) {
				//fibonacci just dependent on two numbers before it
				sum = firstPrevious + secondPrevious;
				secondPrevious = firstPrevious; 
				firstPrevious = sum;
			}
				
			return sum;
		}
	}
	public static void main(String[] args) {
		System.out.println(iterativeFibonacci(8));
	}
}
