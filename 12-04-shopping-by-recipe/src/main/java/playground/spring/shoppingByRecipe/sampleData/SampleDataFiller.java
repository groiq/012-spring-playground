package playground.spring.shoppingByRecipe.sampleData;

import java.util.ArrayList;
import java.util.List;

import playground.spring.shoppingByRecipe.daos.IngredientRepository;
import playground.spring.shoppingByRecipe.daos.RecipeRepository;
import playground.spring.shoppingByRecipe.daos.ShelfRepository;
import playground.spring.shoppingByRecipe.entities.Ingredient;
import playground.spring.shoppingByRecipe.entities.Recipe;
import playground.spring.shoppingByRecipe.entities.Shelf;

public class SampleDataFiller {
	
	private static String[] shelfNames = {"vegetables","side dishes","dairy"};
	private static String[] ingredientNames = {"papric","rice","sour cream"};
	private static String[] recipeNames = {"duvec","potato sauce","risotto"};
	private static int[][] recipeToIngredients = {new int[] {0,1}, new int[] {0,2}, new int[] {1,2}};

	public static void fill(ShelfRepository shelves, IngredientRepository ingredients, RecipeRepository recipes) {

		List<Shelf> shelvesList = new ArrayList<Shelf>();
		List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
		List<Recipe> recipesList = new ArrayList<Recipe>();

		/*
		 * this assumes that each shelf name from the list corresponds with an ingredient name at the same position in the other list.
		 */
		for (int i = 0; i < shelfNames.length; i++) {
			shelvesList.add(new Shelf(shelfNames[i], i));
			ingredientsList.add(new Ingredient(ingredientNames[i], shelvesList.get(i)));
		}

		for (int i = 0; i < recipeNames.length; i++) {
			recipesList.add(new Recipe(recipeNames[i]));
		}

		for (int i = 0; i < recipeToIngredients.length; i++) {
			for (int j = 0; j < recipeToIngredients[i].length; j++) {
				recipesList.get(i).getIngredients().add(ingredientsList.get(j));
			}
		}

		shelves.saveAll(shelvesList);
		ingredients.saveAll(ingredientsList);
		recipes.saveAll(recipesList);

	}
	
	
	
	
}
