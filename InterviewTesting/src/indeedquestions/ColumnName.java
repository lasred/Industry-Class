package indeedquestions;

/**
 * 
 *  Excel names its columns with letters from A to Z, 
 *  and then the sequence goes AA, AB, AC... AZ, BA, BB, etc.
 * @author chris
 *
 */
public class ColumnName {
	public static void main(String[] args) {
		System.out.println("1 is " + getColName(1));
		System.out.println("26 is " + getColName(26));
		System.out.println("27 is " + getColName(27));
		System.out.println("52 is " + getColName(52));
		System.out.println("53 is " + getColName(53));
		System.out.println("78 is " + getColName(78));
	}
	public static String getColName (int colNum) {
		   String res = "";
		   int quot = colNum;
		   int rem;        
		   /*1. Subtract one from number.
		   *2. Save the mod 26 value.
		   *3. Divide the number by 26, save result.
		   *4. Convert the remainder to a letter.
		   *5. Repeat until the number is zero.
		   *6. Return that bitch...
		   */
		    while(quot > 0)
		    {
		    	//distance from a
		        quot = quot - 1;
		        //what value should be for rem * 26^quot
		        rem = quot % 26;
		        quot = quot / 26;

		        //cast to a char and add to the beginning of the string
		        //add 97 to convert to the correct ascii number
		        res = (char)(rem+97) + res;            
		    }   
		    return res;
		}
}
