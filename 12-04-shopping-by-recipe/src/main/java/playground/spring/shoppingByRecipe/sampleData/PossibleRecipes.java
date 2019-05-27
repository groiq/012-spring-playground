package playground.spring.shoppingByRecipe.sampleData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleRecipes {

	private static int selectedElements;
	private static int totalElements;
	
	private static int[] currentSelection;
	
	private static List<int[]> totalSelection;
	
	public static int[][] generateRecipes(int totalElementsParam, int selectedElementsParam) {
		
		selectedElements = selectedElementsParam;
		totalElements = totalElementsParam;
		
		currentSelection = new int[selectedElements];
		totalSelection = new ArrayList<int[]>();
		
		goThroughPossibilities(0,0);
//		System.out.println(totalSelection);
		
//		int[][] result =  (int[][]) totalSelection.toArray();
		int[][] result = new int[totalSelection.size()][];
		for (int i = 0; i < result.length; i++) {
			result[i] = totalSelection.get(i);
		}
		
		return result;
//		return null;
	}

	private static void goThroughPossibilities(int currIndex, int currElement) {
		
		for (int i = currElement; i < totalElements; i++) {
			currentSelection[currIndex] = i;
			if (currIndex < selectedElements-1) {
				goThroughPossibilities(currIndex+1,i+1);
			} else {
//				System.out.println(Arrays.toString(currentSelection));
				totalSelection.add(currentSelection.clone());
			}
		}
		
	}

}
