package playground.snippets;

public class MultiplesOf3And5 {
	// https://projecteuler.net/problem=1
	
	static int[] multiples = {3,5};
	static int limit = 1000;

	public static void main(String[] args) {
		System.out.println("limit: " + limit);
		// TODO Auto-generated method stub
		 boolean[] mapping = new boolean[limit];
//		 for (int i = 0; i < limit; i++) {
//			 System.out.println(i + ": " + mapping[i]);
//		 }
		 for (int i : multiples) {
			 System.out.println("multiple: " + i);
			 int j = 0;
			 while (j < limit) {
//				 System.out.println(j + ": true");
				 mapping[j] = true;
				 j += i;
			 }

		 }
		 
		 int result = 0;
		 for (int i = 0; i < limit; i++) {
			 if (mapping[i] == true) {
//				 System.out.println(i);
				 result += i;
			 }
		 }
		 System.out.println("result: " + result);

	}

}
