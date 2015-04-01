package facebook;

import java.util.Arrays;

/*
 * CCI 11.1 You are given two sorted arrays, A, and B, where A has a large enough 
 * buffer at the end to hold B. Write a method B 
 * to merge B into A in sorted order 
 */
public class Merge {
	
	private static void merge(int[] buffer, int[] reg, int bufferSize) {
		int shift = 0;
		int bufferPointer = 0;
		int regPointer = 0;
		//how many elements are in the first array 
		int len = buffer.length - bufferSize;
		//while there are still elements to insert from the B array
		while(regPointer < reg.length && bufferPointer < len){
			//compasion of the two pointers
			if(buffer[bufferPointer + shift] <= reg[regPointer]){
				bufferPointer++;
			}
			//know buffer[bufferPointer] > reg[regPointer]
			else {
				//shift everything in the buffer by one, make some room
				for(int c=shift+len; c> bufferPointer+shift; c --) {
					buffer[c] = buffer[c-1];
				}
				buffer[bufferPointer + shift] = reg[regPointer];
				shift ++;
				regPointer ++;
			}
		}
		int currentIncrement = 0;
		//know if this is the case, bufferPointer >= len
		if(regPointer < reg.length) {
			for(int c=bufferPointer+shift;c<buffer.length;c++) {
				buffer[c] = reg[regPointer + currentIncrement];
				currentIncrement ++;
			}
		}
	}
	private static void mergeEfficient(int[] buffer, int[] reg, int bufferSize) {
		int bufferPointer = 0;
		int regPointer = 0;
		int num1Elements = buffer.length - bufferSize;
		//first i have to do the shifting 
		for(int c=reg.length+num1Elements-1;c>=reg.length; c--) {
			 buffer[c] = buffer[c-reg.length];
		}
		bufferPointer = reg.length;
		int insertAt = 0;
		//while all the elements have not been inserted
		while(insertAt < buffer.length) {
			if(bufferPointer < buffer.length&& buffer[bufferPointer] <= reg[regPointer]) {
				buffer[insertAt] = buffer[bufferPointer];
				bufferPointer++;
			} else {
				buffer[insertAt] = reg[regPointer];
				regPointer ++;
			}
			insertAt ++;
		}
		//now do the comparisons
	}
	public static void main(String[] args) {
		int[]  buffer = {0, 10, 20, 0, 0, 0};
		int[]  regular = {25, 50, 70};
		mergeEfficient(buffer, regular, 3);
		System.out.println(Arrays.toString(buffer));
	}
}
