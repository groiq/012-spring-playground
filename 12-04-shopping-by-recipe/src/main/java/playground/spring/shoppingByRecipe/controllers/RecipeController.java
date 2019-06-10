package playground.spring.shoppingByRecipe.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import playground.spring.shoppingByRecipe.daos.IngredientRepository;
import playground.spring.shoppingByRecipe.daos.RecipeRepository;
import playground.spring.shoppingByRecipe.daos.ShelfRepository;
import playground.spring.shoppingByRecipe.dbViewObjects.FlatIngredientRepository;
import playground.spring.shoppingByRecipe.dbViewObjects.FlatShelf;
import playground.spring.shoppingByRecipe.dbViewObjects.FlatShelfRepository;
import playground.spring.shoppingByRecipe.dbViewObjects.IngredientInShelfRepository;
import playground.spring.shoppingByRecipe.dbViewObjects.ShoppingShelf;
import playground.spring.shoppingByRecipe.dbViewObjects.ShoppingShelfRepository;
import playground.spring.shoppingByRecipe.entities.Ingredient;
import playground.spring.shoppingByRecipe.entities.Shelf;
import playground.spring.shoppingByRecipe.sampleData.SampleDataFiller;

@Controller
public class RecipeController {
	
	@Autowired
	private IngredientRepository ingredients;
	@Autowired
	private RecipeRepository recipes;
	@Autowired
	private ShelfRepository shelves;
//	@Autowired
//	private ShoppingShelfRepository shoppingShelves;
	@Autowired
	private IngredientInShelfRepository ingredientsInShelves;
	
	@Autowired
	private FlatIngredientRepository flatIngredients;
	@Autowired
	private FlatShelfRepository flatShelves;
	
	@GetMapping("/shopping-by-recipe")
	public ModelAndView shoppingByRecipe() {
		ModelAndView modelAndView = new ModelAndView("shoppingByRecipe");
//		modelAndView.addObject("shelves", shelves.findAll());
//		modelAndView.addObject("ingredients", ingredients.findAll());
		modelAndView.addObject("recipes", recipes.findAll());
		return modelAndView;
	}
	
	/*
	 * if database is empty, fill in some data.
	 */
	@GetMapping("/shopping-by-recipe/fill")
	public String autofill() {
		if (recipes.count() == 0) {
			SampleDataFiller.fill(shelves, ingredients, recipes);
		}
		return "redirect:/shopping-by-recipe";
	}
	
	@GetMapping("/shopping-by-recipe/test-queries")
	public String testQueries() {
		
		System.out.println("----------------------------------");
		
		System.out.println("test queries here:");
//		Optional<Ingredient> lookupIngredient = ingredients.findById(1);
		Ingredient testIngredient = ingredients.findById(4).get();
		System.out.println(testIngredient.getId());
		System.out.println(testIngredient.getName());
		Shelf testShelf = testIngredient.getShelf();
		System.out.println(testShelf);
		System.out.println(testShelf.getId());
		System.out.println(testShelf.getName());
//		List<Ingredient> ingredientList = testShelf.getIngredients();
//		for (Ingredient ingredient : ingredientList) {
//			System.out.println(ingredient.getName());
//		}
//		System.out.println(testIngredient.getShelf());
//		System.out.println(testIngredient);
//		System.out.println(ingredients.findAll());
		
		System.out.println("----------------------------------");
		
//		System.out.println(ingredients.someIngredientQuery());
//		System.out.println(recipes.findAll());
//		System.out.println(ingredients.flatIngredients());
//		System.out.println(ingredients.ingredientByRecipeSortByShelf(10));
//		System.out.println(flatIngredients.findAll());
		
		System.out.println("----------------------------------");
		
		List<FlatShelf> flatShelvesList = flatShelves.findAll();
		System.out.println(flatShelvesList);
		for (FlatShelf flatShelf : flatShelvesList) {
			System.out.println(flatShelf.getName() + ":");
			for (Ingredient curIngredient : flatShelf.getIngredients()) {
				System.out.println("- " + curIngredient.getName());
			}
		}
//		for (FlatShelf flatShelf : flatShelvesList) {
//			System.out.println(flatShelf);
//		}
		
		System.out.println("----------------------------------");
		
		Set<FlatShelf> flatShelvesSet;
		flatShelvesSet = flatShelves.findFlatShelves();
//		flatShelvesSet = (Set<FlatShelf>) flatShelves.findAll();
		for (FlatShelf flatShelf : flatShelvesSet) {
			System.out.println(flatShelf.getName() + ":");
			for (Ingredient curIngredient : flatShelf.getIngredients()) {
				System.out.println("- " + curIngredient.getName());
			}
		}
		
		System.out.println("----------------------------------");


		
		return "redirect:/shopping-by-recipe";
	}
	
	@GetMapping("/shopping-by-recipe/{id}")
	public ModelAndView viewShoppingList(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("viewShoppingList");
		List<Ingredient> ingredientsForRecipe = ingredients.ingredientByRecipeSortByShelf(id);
		System.out.println("----------------------------------");
		System.out.println("subpage for recipe " + recipes.findById(id));
		System.out.println(ingredientsForRecipe);
		for (Ingredient ingredient : ingredientsForRecipe) {
			System.out.println(ingredient.getName() + " in shelf " + ingredient.getShelf().getName());
		}
		System.out.println("----------------------------------");
//		System.out.println("fetching shopping shelves...");
//		Set<ShoppingShelf> shoppingShelfList = shoppingShelves.shoppingListFor(id);
//		for (ShoppingShelf shoppingShelf : shoppingShelfList) {
//			System.out.println(shoppingShelf.getName() + ":");
//			for (Ingredient currIngredient : shoppingShelf.getIngredients()) {
//				System.out.println(" - " + currIngredient.getName());
//			}
//		}
		System.out.println("----------------------------------");
//		System.out.println(recipes.findById(id));
//		List<Ingredient> ingredientsForRecipe = recipes.findIngredientsForRecipe(id);
//		System.out.println(ingredientsForRecipe);
//		System.out.println("----------------------------------");
		return modelAndView;
	}

}
