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

		sampleDataIsSpecific();
		sampleDataIsAbstract();

		
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

	private static void sampleDataIsAbstract() {
		
		int shelfCount;
		int ingredsPerShelf;
		shelfCount = 3;
		ingredsPerShelf = 3;
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
		System.out.println(Arrays.toString(ingredientToShelf));
		
		int ingredsPerRecipe; // cannot be larger than ingredsPerShelf
		
		ingredsPerRecipe = 2;
		
		
		
		recipeNames = new String[] {"potato salad","duvec","papric sauce","risotto"};
		recipeToIngredients = new int[][] {new int[] {2,3,5,6}, new int[] {0,1,3,4}, new int[] {0,1,3,7}, new int[] {1,4,8}};
		
	}

	private static void sampleDataIsSpecific() {
		shelfNames = new String[] {"vegetables","dry goods","dairy"};
		ingredientNames = new String[] {"papric","tomato","potato","onions","rice","oil","vinegar","sour cream","cream"};
		ingredientToShelf = new int[] {0,0,0,0,1,1,1,2,2};
		recipeNames = new String[] {"potato salad","duvec","papric sauce","risotto"};
		recipeToIngredients = new int[][] {new int[] {2,3,5,6}, new int[] {0,1,3,4}, new int[] {0,1,3,7}, new int[] {1,4,8}};
	}
	
	public static void main(String[] args) {
		
		System.out.println("testing sample data filler");
		sampleDataIsAbstract();
		
	}
	
	
}
