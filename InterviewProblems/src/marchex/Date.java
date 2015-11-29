package marchexquestion;

/*
 * Marchex Month apart problem 
 */
public class Date {
	private static final int MONTHS_IN_YEAR = 12;
	private static final int EXACT_MONTH_APART = 0;
	private static final int LESS_THAN_MONTH_APART = -1;
	private static final int GREATER_THAN_MONTH_APART = 1;
	private int month;
	private int day;
	private int year;
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	public String toString() {
		String rep= "";
		if(month < 10) {
			rep += "0";
		}
		rep+= month+"/";
		if(day < 10) {
			rep += "0";
		}
		rep += day + "/";
		return rep + year;
	}
	/*
	 * Return the correct code
	 *
	 */
	private int compareTo(Date other) {
		//2/14/2015 3/14/2015
		//rather than all these else ifs, generate some code, compare some total
		int myTotalMonths = MONTHS_IN_YEAR * year + month;
		int otherTotalMonths = MONTHS_IN_YEAR * other.year + other.month;
		if(myTotalMonths ==  otherTotalMonths) {
			//same month and year
			return LESS_THAN_MONTH_APART;
		} else {
			//if distance between months is 1
			if(Math.abs(myTotalMonths - otherTotalMonths) == 1) {
				if(other.day == this.day) {
					return EXACT_MONTH_APART;
				} else if( 
						(myTotalMonths < otherTotalMonths && other.day < this.day)
					||(myTotalMonths > otherTotalMonths
					   && other.day > this.day) ){
					//   2/16/2015     3/14/2015
					//   3/14/ 2015    2/16/2015
					//   3/14/2015     2/13/2015
					//   4/15/2015   4/5/2015
					return LESS_THAN_MONTH_APART;
				} else {
					// 2/16/2015   3/20/2015
					return GREATER_THAN_MONTH_APART;
				}
			} else if(myTotalMonths == otherTotalMonths) {
				return LESS_THAN_MONTH_APART;
			} else {
				return GREATER_THAN_MONTH_APART;
			}
		}
	}
	public String getCompMessageComparison(Date other) {
		int code = compareTo(other);
		String message;
		switch(code) {
		case LESS_THAN_MONTH_APART :
			message=  "dates are less than a month apart";
			break;
		case GREATER_THAN_MONTH_APART :
			message = "dates are more than a month apart";
			break;
		default: 
			message = "dates are an exact month apart";
		} 
		return message;
		
	}
}
