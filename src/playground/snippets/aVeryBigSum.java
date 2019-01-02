package playground.snippets;

/*
 * after https://www.hackerrank.com/challenges/a-very-big-sum/problem
 * 
 * handling sums exceeding max range of a numerical data type.
 * Thought: Instead of using a larger data type, track how much the sum *differs* from maximum.
 * 
 * Problem: Even if I use tricks while calculating a sum, I'd have to cast type to return the result.
 * workaround: I won't calc a sum, instead I'll compare two sums.
 * Input two arrays of numbers, return a boolean - true if first sum is larger than second.
 * Ignore "both sums equal" cases for now.
 * 
 * Data type is byte, which is the smallest integer-ish data type in Java (-127-128).
 * 
 * No, wait - I'll just return the result in a form like "twice 128 and 33".
 * 
 * That is: return a two-integer array - first integer tells how often it crossed over, second one the "remainder".
 * Data type is byte.
 * Throw at another function that converts to int and calculates the result.
 * 
 * Third function calculates everything as an int.
 * 
 */

public class aVeryBigSum {
	
	static byte[] calculateAsByte(byte[] nums) {
		
		byte[] result = new byte[2];
		result[0] = 0;
		result[1] = 0;
		
		for (byte item : nums) {
			System.out.println("times: " + result[0] + ", remainder: " + result[1] + ", adding " + item + ".");
			if (Byte.MAX_VALUE - item < result[1]) {
				result[0] += 1;
				result[1] = (byte) (item - (Byte.MAX_VALUE - result[1]));
			} else {
				result[1] += item;
			}
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		
		byte[] testCase = {126,3};
		
		int verify = 0;
		for (byte item : testCase) {
			int itemInt = (int) item;
			verify += itemInt;
		}
		
		System.out.println("Verify: " + verify);
		
		byte[] zwischenergebnis = calculateAsByte(testCase);
		for (byte item : zwischenergebnis) { System.out.println(item); }
		

	}

}
