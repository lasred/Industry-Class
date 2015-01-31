package indeedquestions;


/**
 * The second question is searching a particular word in a string,
 *  and add "<b>" "<\b>" around the word's every appearance
 *
 */
public class AddBsAround {
	public static void main(String[] args) {
		String testCase = " install  all    all programs";
		System.out.println(addBsSpaces(testCase, "all"));
	}
	
	public static String addBs(String sentence, String word) { 
		String result = "";
		String[] words = sentence.trim().split("\\s+");
		for(String wordInSentence: words) {
			if(wordInSentence.equals(word)) {
				result += "<b>" +word + "</b> ";
			}  else {
				result += wordInSentence + " "; 
			}
		}
		return result;
	}
	public static String reverseString(String normalString) {
		   StringBuilder sb = new StringBuilder();
		   for(int i = normalString.length() - 1; i >= 0; --i)
		     sb.append(normalString.charAt(i));
		   return sb.toString();
		 }
	public static String addBsSpaces(String sentence, String word) { 
	    StringBuilder result = new StringBuilder();
	    String[] words = sentence.trim().split("\\s");
	    for(String wordInSentence: words) {
	      if(wordInSentence.equals(word)) {
	        result.append("<b>").append(word).append("</b> ");
	      }  else {
	        result.append(wordInSentence).append(" "); 
	      }
	    }
	    return result.toString();
	  }
	}

