package facebook;

public class Anagrams {
	//
	static boolean isPermutation(String phrase1, String phrase2) {
		if(phrase1.length()!=phrase2.length())
			return false;
		int[] phrase1Ascii = new int[256];
		int len1 = phrase1.length();
		for(int c=0;c<len1;c ++) {
			phrase1Ascii[(int)phrase1.charAt(c)]++;
		}
//		int[] phrase2Ascii = new int[256];
		int len2 = phrase2.length();
		for (int c=0;c<len2;c++) {
			int asciiToInvestigate = (int)phrase2.charAt(c);
			phrase1Ascii[asciiToInvestigate] --;
			if(phrase1Ascii[asciiToInvestigate] < 0) 
				return false;
//			if(phrase2Ascii[asciiToInvestigate] > phrase1Ascii[asciiToInvestigate])
//				return false;
//			phrase2Ascii[asciiToInvestigate] ++;
		}
		//This is for the case of "dddd" vs "", they are not permutations
//		for(int c=0;c<256;c++) {
//			if(phrase1Ascii[c] != phrase2Ascii[c]) 
//				return false;
//		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isPermutation("ic!man4", "cin!m3a"));
	}
}
