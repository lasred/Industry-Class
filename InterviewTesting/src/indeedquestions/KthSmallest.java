package indeedquestions;
/**
 * Problem specifications
 * Given array of integers(Not sorted), find kth smallest element in that sorted arrray 
 * 2 3 1 5 7 6 9
 * 4th smallest - 5
 * 
 * Brute force - sort the array, return a[k], a[3] for 4th smallest
 * Complexity of brute force - n(logn) with mergesort, good selection of pivot in quicksort 
 *
 *Quicksort - position of pivot, left are less than pivot, right are greater than pivot
 
 */
public class KthSmallest {
	public static void main(String[] args) {
		int[] test = {2,3,1,5,7,6,9};
		System.out.println("4th smallest is " + quick_select(test, 4, 0, test.length - 1));
	}
	private static int quick_select(int[] a, int k, int left, int right) {
	     int pivot=findpivot(a,left,right);
	     if(pivot==k-1){
	          return a[pivot];
	     }
	     if(k-1<pivot){
	          return quick_select(a, k, left, pivot-1);
	      }
	      else {
	          return quick_select(a, k, pivot+1, right);
	      }
	    }
	    private static int findpivot(int[] a, int left, int right) {
	        int pivot = a[(left+right)/2];
	        while(left<right){
	            while(a[left]<pivot){
	                left++;
	            }
	            while(a[right]>pivot){
	                right--;
	            }
	            if(left<=right){
	                swap(a,left,right);
	                left++;
	                right--;
	            }
	        }
	        return left;
	    }

	    private static void swap(int[] a, int i, int j) {
	        int temp=a[i];
	        a[i]=a[j];
	        a[j]=temp;

	    }

	
}
