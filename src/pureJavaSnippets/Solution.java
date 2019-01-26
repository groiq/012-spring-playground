package pureJavaSnippets;

// working class for https://www.hackerrank.com/ exercises

public class Solution {
	
    static int pageCount(int n, int p) {
        
    	System.out.println("entering function...");
    	
    	// calculate turning from front:
    	// pg 1 -> 0; 2,3 -> 1; 4,5 -> 2
    	// that's exactly the modulo of the page number!
    	
    	// calculate turning from back:
    	// for now, get number of sheets...
    	// that's modulo + 1
    	
    	
    	
    	
    	return n;

    }


	public static void main(String[] args) {
		
    	// drawing book
    	// 6 / 1,2,3,...
    	// 7 / 1,2,3,...
    	// get half of the number
    	// test all solutions
    	
    	// (0,1),(2,3),...
    	// oder:
    	// (0),(1,2),(3,4) -> (1),(2,3),(4,5),...
    	
    	// 6,2 -> 1
    	// 5,4 -> 0
    	System.out.println("6,2 -> 1 :: " + pageCount(6,2));
    	System.out.println("5,4 -> 0 :: " + pageCount(5,4));


	}

}
