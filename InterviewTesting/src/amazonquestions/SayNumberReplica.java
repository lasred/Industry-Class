package amazonquestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SayNumberReplica {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        String phrase;
       do {
           System.out.print("Enter number(q to quit): ");
             phrase = s.next();
             if(!phrase.equals("q")) {
            	 try{
            		 int n = Integer.parseInt(phrase);
            		 String output = getStringRepresentation(Math.abs(n));
     		        if(n < 0) {
     		        	output = "negative" + output;
     		        }
     		        System.out.println("Output: " + output);
            	 }catch(NumberFormatException e){
            		 System.out.println("Please enter a number");
            	 }
      
             }
        } while(!phrase.equals("q"));
	}
	/**
	 * Generatea map of how to say the ones 
	 * @return
	 */
	private static Map<Integer, String> generateOnesMap() {
		Map<Integer, String> sayOnes = new HashMap<Integer, String>();
		int[] ones = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
				13, 14, 15, 16, 17, 18, 19};
		String[] howYouSayOnes = {"One", "Two", "Three", "Four", "Five", "Six",
				 "Seven", "Eight", "Nine", "Ten", "Eleven","Twelve", "Thirteen", "Fourteen",
				  "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		for(int c=0;c<ones.length;c++) {
			sayOnes.put(ones[c], howYouSayOnes[c]);
		}
		return sayOnes;
	}
	private static Map<Integer, String> generateTensMap() {
		Map<Integer, String> sayTens = new HashMap<Integer, String>();
		//just need to go from twenty to ninety 
		int[] tens = {2, 3, 4, 5, 6, 7, 8, 9};
		String[] howYouSayTens = {"Twenty", "Thirty", "Fourty", 
				"Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		for(int c=0;c<tens.length;c++) {
			sayTens.put(tens[c], howYouSayTens[c]);
		}
		return sayTens;
	}
    /**
     * Function to take in an integer and return how to say that integer in 
     * English  123 -> one hundred twenty three  5019 - five thousand nineteen
     * @param abs
     * @return
     */
	private static String getStringRepresentation(int abs) {
		if(abs == 0) {
			return "Zero";
		}
		if(Math.abs(abs) >= 1000000000)
			throw new IllegalArgumentException("Shit we haven't implemented this yet");
		String howSay = "";
		if(abs >= 1000000) {
			int numMillion = abs / 1000000;
			howSay += howToSayUpToThousand(numMillion);
			howSay += " Million ";
			abs = abs % 1000000;
		}
		if(abs >= 1000) {
			//how do you say numThousands
			int numThousands = abs / 1000;
			howSay += howToSayUpToThousand(numThousands);
			howSay += " Thousand ";
			//comment - process the rest of this
			abs  = abs % 1000;
		}
		if(abs > 0) {
			//how to say the rest of it
			howSay += howToSayUpToThousand(abs);
		}
		return howSay;
	}
	private static String howToSayUpToThousand(int n) {
		String howSay = "";
		Map<Integer, String> howYouSayOnes = generateOnesMap();
		if(n >= 100) {
			int numHundreds = n / 100;
			howSay += howYouSayOnes.get(numHundreds) +  " Hundred ";
			n = n % 100;
		}
		if(n >= 20) {
			Map<Integer, String> howYouSayTens = generateTensMap();
			int tensPlace = n / 10;
			howSay += howYouSayTens.get(tensPlace) + " ";
			n = n % 10;
		}  
		if(n > 0){
			 howSay += howYouSayOnes.get(n);
		} 
		return howSay;
	}
}
