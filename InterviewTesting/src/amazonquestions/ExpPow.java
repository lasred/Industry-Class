package amazonquestions;

public class ExpPow {
	static void checkPow(int pow) {
		if(pow < 0 ) {
			throw new IllegalArgumentException("This function does not handle negative"
					+ " exponents");
		}
	}
	public static int pow(int base, int pow) {
		checkPow(pow);
		if(pow == 0) {
			return 1;
		} else{
			return base * pow(base, pow - 1);
		}
	}
	
	public static int powConSpace(int base, int pow) {
		checkPow(pow);
		int result = 1;
		for(int count=1;count<=pow;count++) {
			result*=base;
		}
		return result;
	}
	
	public static int logPow(int base, int pow ) {
		checkPow(pow);
		if(pow == 0) {
			return 1;
		} else {
			int result = logPow(base*base, pow/2);
			if(pow%2 == 1) {
				 result*=base;
			}
			return result;
		}
		
	}
	
	public static int logConSpace(int base, int pow) {
		checkPow(pow);
		if(pow == 1) {
			return base;
		} else {
			 int result = 1;
			 while(pow>0) {
				 if(pow%2 == 0)
					 result*=base;
				 base *= base;
				 pow = pow/2;
			 }
			 return result;
		}
	}
	public static void main(String[] args) {
		System.out.println(logConSpace(64,0));
	}
}
