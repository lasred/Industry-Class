package indeedquestions;
/**
 * Indeed actual interview problem 1/23/15
 * @author chris sun 
 * Truncate(reduce a string in the following format)
 * Say String s = "I want  myself right now!"
 * gT(s, 1) - "I"      gT(s,2) - "I"   gT(s, 6) - "I want"   
 * gT(s, s.length - 1) - "I want myself right"
 */
public class StringTruncation {
	public static String getTruncation(String toBe, int num) {
		if(num < 0) {
			throw new IllegalArgumentException();
			//optimization
		} if(num >= toBe.length()) {
			return toBe.trim();
		} else {
			StringBuilder build = new StringBuilder();
			//know 0<=num< toBe.length()
			int indexOfEndOfNextWord = toBe.indexOf(" ");
			
				
			return build.toString();
		}
	}
}
