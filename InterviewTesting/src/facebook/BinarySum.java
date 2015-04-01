package facebook;

public class BinarySum {
	private static String sumNoConv(String bin1, String bin2) {
		StringBuilder sumToReverse = new StringBuilder("");
		if(bin1.length() > bin2.length()) 
			 bin2 = appendZeros(bin2, bin1.length() - bin2.length());
		else if(bin1.length() < bin2.length())
			 bin1 = appendZeros(bin1,bin2.length() - bin1.length());
		int len = bin1.length();
		byte carryBit = 0;
		for(int c=len-1;c>=0; c--) {
			//first lets evlauate the char at those locations
			byte atFirstPos = bin1.charAt(c) == '1'?(byte)1:0;
			byte atSecondPos = bin1.charAt(c) == '1'?(byte)1:0;
			//now sum everyting
			byte sum = (byte) (atFirstPos + atSecondPos + carryBit);
			sumToReverse.append(sum%2);
			if(sum >= 2)
				carryBit = 1;
		}
		if(carryBit==1)
			sumToReverse.append(carryBit);
		return sumToReverse.reverse().toString();
	}
	private static String appendZeros(String appendTo, int numZeros) {
		StringBuilder appendedPortion = new StringBuilder("");
		for(int c=0;c<numZeros;c++)
			appendedPortion.append('0');
		//O(n)
		return appendedPortion.toString() + appendTo;
 	}
	private static String sum(String bin1, String bin2) {
		int dec1 = binToDec(bin1);
		int dec2 = binToDec(bin2);
		int sumTo = dec1 + dec2;
		//two ways to do it
		//String bin = "";
		//more efficient than string concatenation 
		StringBuilder build = new StringBuilder("");
		//convertSumTo to binary 
		do {
			//bin = sumTo%2  + bin;
			build.append(sumTo%2);
			sumTo = sumTo/2;
		}while(sumTo > 0);
		//return bin;
		//O(n) space n - number of binary digits
		return build.reverse().toString();
	}
	private static int binToDec(String bin) {
		int result = 0;
		int len = bin.length();
		for(int rep=len-1;rep>=0;rep--) {
			int multiplyBy = bin.charAt(rep)=='1'?1:0;
			//zerobased;
			result += multiplyBy * Math.pow(2, len-1 - rep);
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(sum("10001011001", "1111101001"));
	}
	
}
