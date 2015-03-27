package gree;

public class ReverseString {
	/*
	 * String - immutable, once created, cannot change. String is 
	 * created in the constant String Pool 
	 * String - thread safe, cannot be used by two threads simultaneously 
	 * 
	 * Say you have String ref = "Hi"
	 * Each time you do String concatenation, say ref +=, you are
	 * creating a  new String in the constant String pool 
	 * 
	 * Say we have  String demo = "hello"
	 * The "hello" is stored in constant string pool, its value cannot be modifiied
	 */
	public static String reverseString(String toReverse){
		/*
		 * StringBuilder - mutable, value of the object can be changed
		 * Memory is allocated from the heap for this object. StringBuilder
		 * faster than StringBuffer because Stringbuffer is thread safe 
		 */
		StringBuilder build = new StringBuilder();
		for(int count=toReverse.length()-1;count>=0;count--) {
			build.append(toReverse.charAt(count));
		}
		return build.toString();
	}
	public static void main(String[] args) {
		System.out.println(reverseString("Chris"));
	}
}
