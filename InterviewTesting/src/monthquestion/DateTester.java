package monthquestion;

public class DateTester {
	//Don't want to initialize date tester
	private DateTester() {
		
	}
	private static void printInformation(Date d1, Date d2) {
		System.out.printf("%s and %s are %s\n", d1.toString(), d2.toString(),
	        d1.getCompMessageComparison(d2));
		
	}
	public static void main(String[] args) {
		// 2/4/2011 2/4/2012
		printInformation(new Date(2, 4, 2011), new Date(2, 4, 2012));
		printInformation(new Date(2, 16, 2014), new Date(3, 14, 2014));
		printInformation(new Date(3, 14, 2014), new Date(2, 16, 2014));
	    printInformation(new Date(3, 14, 2014), new Date(2, 13, 2014));
	    printInformation(new Date(3, 4, 2011), new Date(3, 17, 2011));
	    printInformation(new Date(12, 17, 2015), new Date(1, 17, 2016));

	}	
}
