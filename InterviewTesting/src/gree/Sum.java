package gree;

public class Sum {
	public static void main(String[] args) {
		int[] elements = {5, 4, 1, 7, 9, 10, 8};
		sumTo(elements, 17);
	}
	public static int median(int[] array, int a, int b, int c) {
		if(array[a] == array[c] || array[a] == array[b]) 
			return a;
		else if(array[b] == array[c])
			return b;
		int absMax = Math.max(Math.max(array[a], array[b]), Math.max(array[b], array[c]));
		int absMin = Math.min(Math.min(array[a], array[b]), Math.min(array[b], array[c]));
		if(array[a] != absMax && array[a] != absMin) {
			return a;
		} else if (array[b] != absMax && array[b] != absMin) {
			return b;
		} else {
			return c;
		}
	}
	public static void sumTo(int[] elements, int sumTo) {
		//sort elements O(n log n), median of three pivot approach to optimize runtime
		quickSort(elements);
		int leftPointer = 0;
		int rightPointer = elements.length - 1;
		while(leftPointer<rightPointer) {
			if(elements[leftPointer] + elements[rightPointer] == sumTo) {
				System.out.println(elements[leftPointer] + " + " +
						elements[rightPointer]  + " = " + sumTo );
				leftPointer ++;
				rightPointer --;
			} else if(elements[leftPointer] + elements[rightPointer] < sumTo) {
				leftPointer ++;
			} else {
				rightPointer --;
			}
		}
	}
	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}
	private static void quickSort(int[] a, int min, int max) {
		if (min >= max) { // base case; no need to sort
			return;
		}
		/*
		 * Use the median of the three approach- look at left/middle/right
		 * elements and the medium value of the three
		 * Near optimal runtime for almost all input orderings, better 
		 * performance than picking random numbers each time
		 */
		int pivot = median(a, min, max, (min + max) /2);
		swap(a, pivot, max); // move pivot to end
		// partition the two sides of the array
		int middle = partition(a, min, max - 1, a[max]);
		swap(a, middle, max); // restore pivot to proper location
		// recursively sort the left and right partitions
		quickSort(a, min, middle - 1);
		quickSort(a, middle + 1, max);
	}
	private static int partition(int[] a, int i, int j, int pivot) {
		while (i <= j) {
			// move index markers i,j toward center
			// until we find a pair of out-of-order elements
			while (i <= j && a[i] < pivot) 
				i++;
			while (i <= j && a[j] > pivot) 
				j--; 
			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		return i;
	}
	public static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
