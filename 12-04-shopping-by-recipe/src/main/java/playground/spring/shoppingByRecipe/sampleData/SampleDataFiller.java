package playground.spring.shoppingByRecipe.sampleData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import playground.spring.shoppingByRecipe.daos.IngredientRepository;
import playground.spring.shoppingByRecipe.daos.RecipeRepository;
import playground.spring.shoppingByRecipe.daos.ShelfRepository;
import playground.spring.shoppingByRecipe.entities.Ingredient;
import playground.spring.shoppingByRecipe.entities.Recipe;
import playground.spring.shoppingByRecipe.entities.Shelf;

public class SampleDataFiller {
	

	private static String[] shelfNames;
	private static String[] ingredientNames;
	private static int[] ingredientToShelf;
	private static String[] recipeNames;
	private static int[][] recipeToIngredients;

	public static void fill(ShelfRepository shelves, IngredientRepository ingredients, RecipeRepository recipes) {

//		sampleDataIsSpecific();
//		sampleDataIsAbstract();
//		sampleDataIsSemiAbstract();
		specificSampleData02();

		
		List<Shelf> shelvesList = new ArrayList<Shelf>();
		List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
		List<Recipe> recipesList = new ArrayList<Recipe>();
		
		for (int i = 0; i < shelfNames.length; i++) {
			shelvesList.add(new Shelf(shelfNames[i], i));
		}
		
		for (int i = 0; i < ingredientNames.length; i++) {
			ingredientsList.add(new Ingredient(ingredientNames[i], shelvesList.get(ingredientToShelf[i])));
		}
		
		
		for (int i = 0; i < recipeNames.length; i++) {
			recipesList.add(new Recipe(recipeNames[i]));
		}

		for (int i = 0; i < recipeToIngredients.length; i++) {
			for (int j = 0; j < recipeToIngredients[i].length; j++) {
				recipesList.get(i).getIngredients().add(ingredientsList.get(recipeToIngredients[i][j]));
			}
		}

		shelves.saveAll(shelvesList);
		ingredients.saveAll(ingredientsList);
		recipes.saveAll(recipesList);

	}
	

	private static void sampleDataIsSemiAbstract() {
		shelfNames = new String[] {"s0","s1","s2"};
		ingredientNames = new String[] {"s0-0","s0-1","s1-2","s1-3","s2-4","s2-5"};
		ingredientToShelf = new int[] {0,0,1,1,2,2};
		recipeNames = new String[] {"r0","r1"};
		recipeToIngredients = new int[][] {new int[] {0,1,2}, new int[] {3,4,5}};
	}

	private static void sampleDataIsAbstract() {
		
		int shelfCount;
		int ingredsPerShelf;
		int ingredsPerRecipe; // cannot be larger than ingredsPerShelf
		
		shelfCount = 3;
		ingredsPerShelf = 3;
		ingredsPerRecipe = 2;
		
		shelfNames = new String[shelfCount];
		ingredientNames = new String[shelfCount * ingredsPerShelf];
		ingredientToShelf = new int[shelfCount * ingredsPerShelf];
		
		for (int i = 0; i < shelfCount; i++) {
			String curShelf = "s" + i;
//			System.out.println(curShelf);
			shelfNames[i] = (curShelf);
			for (int j = 0; j < ingredsPerShelf; j++) {
				String curIngred = curShelf + "-i" + j;
//				System.out.println(curIngred);
				int ingredsPosition = (i*ingredsPerShelf) + j;
//				System.out.println(ingredsPosition);
				ingredientNames[ingredsPosition] = curIngred;
				ingredientToShelf[ingredsPosition] = i;
			}
			
		}
		
		System.out.println(Arrays.toString(shelfNames));
		System.out.println(Arrays.toString(ingredientNames));
		System.out.println("ingredient to shelf: " + Arrays.toString(ingredientToShelf));
		
		int[][] recipeSelectors = PossibleRecipes.generateRecipes(ingredsPerShelf, ingredsPerRecipe);
		recipeNames = new String[recipeSelectors.length];
		for (int i = 0; i < recipeSelectors.length; i++) {
//			System.out.println("curr recipe selector: " + Arrays.toString(recipeSelectors[i]));
			recipeNames[i] = "r";
			for (int j : recipeSelectors[i]) {
				recipeNames[i] += j;
			}
		}
		System.out.println("recipeNames: " + Arrays.toString(recipeNames));

		System.out.println("ingredientNames: " + Arrays.toString(ingredientNames));
		
		
		recipeToIngredients = new int[recipeNames.length][];
		
		for (int i = 0; i < recipeToIngredients.length; i++) {
			recipeToIngredients[i] = new int[ingredsPerRecipe*shelfCount];
			for (int j = 0; j < shelfCount; j++) {
				// values from recipeSelector

				for (int k = 0; k < recipeSelectors[i].length; k++) {
					int posInIngredientNames = j * ingredsPerShelf + recipeSelectors[i][k];
					int posInRecipeToIngredients = j * ingredsPerRecipe + k;
					recipeToIngredients[i][posInRecipeToIngredients] = posInIngredientNames;
					
				}
			}
			System.out.println("entry in recipeToIngredients: " + Arrays.toString(recipeToIngredients[i]));
		}
		
//		recipeToIngredients = PossibleRecipes.generateRecipes(ingredsPerShelf,ingredsPerRecipe);

//		System.out.println(Arrays.toString(recipeToIngredients));
		
//		recipeNames = new String[recipeToIngredients.length];
//		for (int i = 0; i < recipeToIngredients.length; i++) {
//			System.out.println(Arrays.toString(recipeToIngredients[i]));
//			recipeNames[i] = "r" + recipeToIngredients[i][0] + recipeToIngredients[i][1];
//		}
//		System.out.println(Arrays.toString(recipeNames));
		
		
//		recipeNames = new String[] {"potato salad","duvec","papric sauce","risotto"};
//		recipeToIngredients = new int[][] {new int[] {2,3,5,6}, new int[] {0,1,3,4}, new int[] {0,1,3,7}, new int[] {1,4,8}};
		
	}

	private static void sampleDataIsSpecific() {
		shelfNames = new String[] {"vegetables","dry goods","dairy"};
		ingredientNames = new String[] {"papric","tomato","potato","onions","rice","oil","vinegar","sour cream","cream"};
		ingredientToShelf = new int[] {0,0,0,0,1,1,1,2,2};
		recipeNames = new String[] {"potato salad","duvec","papric sauce","risotto"};
		recipeToIngredients = new int[][] {new int[] {2,3,5,6}, new int[] {0,1,3,4}, new int[] {0,1,3,7}, new int[] {1,4,8}};
	}
	
	private static void specificSampleData02() {
		shelfNames = new String[] {"fresh produce","dry goods","dairy"};
		ingredientNames = new String[] {"onions","potatoes","oil","vinegar","rice","cream"};
		ingredientToShelf = new int[] {0,0,1,1,1,2};
		recipeNames = new String[] {"potato salad","risotto","potatoes au gratin"};
		recipeToIngredients = new int[][] {new int[] {0,1,2,3}, new int[] {0,2,4,5}, new int[] {0,1,5}};
	}

	public static void main(String[] args) {
		
		System.out.println("testing sample data filler");
		sampleDataIsAbstract();
		
	}
	
	
}
