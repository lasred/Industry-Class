package amazonquestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Permutations {

	public static void subsets(Set<Integer> s) {
		Queue<Integer> copyToProtectData  = new LinkedList<Integer>();
		for(int member: s) {
			copyToProtectData.add(member);
		}
		generateSubsets(copyToProtectData, new HashSet<Integer>());
	}
	private static void generateSubsets(Queue<Integer> s, 
			 Set<Integer> hashSet) {
		if(s.isEmpty()) {
			System.out.println(hashSet);
		} else {
			//no need to backtrack
			int member = s.remove();
			//make copy 
			Set<Integer> copy = new HashSet<Integer>();
			for(int i:hashSet) {
				copy.add(i);
			}
			//the one that has the element
			hashSet.add(member);
			Queue<Integer> queueCopy = new LinkedList<Integer>();
			for(int i:s){
				queueCopy.add(i);
			}
			generateSubsets(s, hashSet);
			//the one that doesn't have the element
			generateSubsets(queueCopy, copy);			
		}
	}
	public static void generatePerm(String s) {
		Queue<Character> poss = new LinkedList<Character>();
		int len = s.length();
		for(int count=0;count<len;count++)
			poss.add(s.charAt(count));
		generateRecurse(poss, len, "");
	}
	private static void generateRecurse(Queue<Character> possibles, int n, String word) {
		if(n==0)
			System.out.println(word);
		else {
			for(int count=0;count<n;count++) {
				//make choice
				char first = possibles.remove();
				//recurse
				generateRecurse(possibles, n-1, word+first);
				//"unmake choice"
				possibles.add(first);
			}
		}
	}
	public static List<Integer> indexOfAnagrams(List<String> words, String phrase) {
		List<Integer> indexes = new ArrayList<Integer>();
		//distances, ascii
		int[] distances = new int[256];
		for(int c=0;c<phrase.length();c++) {
			char letterAt = Character.toLowerCase(phrase.charAt(c));
			distances[letterAt] ++;
		}
		for(int c=0;c<words.size();c++) {
			String word = words.get(c);
			if(isAnagram(word, distances, phrase.length())) {
				indexes.add(c);
			}
		}
		return indexes;
	}
	private static boolean isAnagram(String word1, int[] counts, int length) {
		//optimization
		if(word1.length()!=length)
			return false;
		int[] distances = new int[256];
		//optimization
		for(int c=0;c<length;c++) {
			char letterAt = Character.toLowerCase(word1.charAt(c));
			distances[letterAt] ++;
			//another optimization
			if(distances[letterAt] > counts[letterAt]) 
				return false;
		} 
		for(int c=0;c<256;c++) {
			if(counts[c]!=distances[c]) 
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
//		List<String> words = new ArrayList<String>();
//		words.add("rapes");
//		words.add("rate!");
//		words.add("chris");
//		words.add("blazer");
//		words.add("ta!er");
//		words.add("cates");
//		words.add("!tare");
//		System.out.println(indexOfAnagrams(words, "tear!"));
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		subsets(set);
	
	}
}
