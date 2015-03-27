package amazonquestions;

import java.util.HashSet;
import java.util.Set;

public class BinaryPalindrome {
	private static Set<String> getAllComb(int n) {
		  //store all the possibilities, make sure we don't get any duplicates
		  Set<String> allPoss = new HashSet<String>();
		  if(n>0) {
			  if(n==1) {
				  //simple action 
				  allPoss.add("()");
			  } else {
				  /**get the previous set, for each one, try after every '(',
				  including the beginning**/
				  Set<String> before = getAllComb(n-1);
				  for(String phrase: before) {
					  //looking at each word
					  int length = phrase.length();
					  for(int start = length - 2; start>=0; start--) {
						  //do our than
						  if(phrase.charAt(start) == '(') {
							  String phraseToConsider = phrase.substring(0, start+1) + "()" +
						           phrase.substring(start + 1);
							  if(!allPoss.contains(phraseToConsider)){
								  allPoss.add(phraseToConsider);
							  }
						  }
					  }
					  //consider the very beginning 
					  String phraseToConsider = "()" + phrase.substring(0);
					  if(!allPoss.contains(phraseToConsider)){
						  allPoss.add(phraseToConsider);
					  }
				  }
			  }
		  }
		  return allPoss;
	}
	private static boolean isBinaryPalindrome(int n) {
		String binaryRep = "";
		do {
			//do while to take care of 0
			binaryRep += n%2;
			n = n/2;
		}while(n>0);
		for(int i=0;i<binaryRep.length()/2;i ++) {
			//take care of palindromes
			if(binaryRep.charAt(i) != 
				binaryRep.charAt(binaryRep.length() - i- 1)) 
					return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isBinaryPalindrome(2));
		System.out.println(getAllComb(3));
	}
}
