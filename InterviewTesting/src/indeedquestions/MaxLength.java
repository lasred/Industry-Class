package indeedquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * The asked me a method that took in a string and return words up to the max length.
 *  There could be any amount of spaces which made it a little tricky  
 *
 */
public class MaxLength {
	public static void main(String[] args) {
		List<String> allWords = maxWords("Jasmine  has   no love  for chris", 3);
		for(String word: allWords){
			System.out.print(word + " ");
		}
		System.out.println();
	}
	//Jasmine   has no love  for chris 
	public static List<String> maxWords(String sentence, int length) {
		String[] words = sentence.trim().split("\\s+");
		List<String> list = new ArrayList<String>();
		for(String word: words) {
			if(word.length() <= length) {
				list.add(word);
		    }
		}
		return list;
	}
	public static List<String> maxWords2(String sentence, int length) {
        List<String> list = new ArrayList<String>();
        String tmp = sentence;
        while (tmp.indexOf(" ") != -1) {
            String word = tmp.substring(0,tmp.indexOf(" "));
            tmp = tmp.substring(tmp.indexOf(" ")+1);
            if(word.length() <= length) {
                list.add(word);
            }
        }
        return list;
    }
	
}
