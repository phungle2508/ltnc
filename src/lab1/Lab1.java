package lab1;

public class Lab1 {
	public int roundNumber(float n) {
		int nAsInt =  (int) n;
        double decimalPart = n - nAsInt;
        
        int decimalAsInt = (int) (decimalPart * 10); 
        
        return decimalAsInt < 5 ? nAsInt : nAsInt +1 ;

	}
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		int count = 2;
		while (count < n) {
			if (n % count == 0) {
				return false;
			}
			count++;
		}
		return true;

	}
	public static int countDigit(int n) {
	    if (n == 0) {
	        return 1; 
	    }

		int count = 0;
		int remaning = n;
		while (true) {
			if (remaning / 10 == 0) {
				return count + 1;
			}else {
				remaning = remaning / 10;
				count ++ ;
			}
		}
	}
	public static void main(String[] args) {
		Lab1 lab1 = new Lab1();
		System.out.println(lab1.roundNumber(5.455f));
//		System.out.println(countDigit(5555));
		
	}
}
