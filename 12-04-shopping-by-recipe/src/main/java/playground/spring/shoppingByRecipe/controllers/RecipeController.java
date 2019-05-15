package playground.spring.shoppingByRecipe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import playground.spring.shoppingByRecipe.daos.IngredientRepository;
import playground.spring.shoppingByRecipe.daos.RecipeRepository;
import playground.spring.shoppingByRecipe.daos.ShelfRepository;
import playground.spring.shoppingByRecipe.entities.Ingredient;
import playground.spring.shoppingByRecipe.entities.Recipe;
import playground.spring.shoppingByRecipe.sampleData.SampleDataFiller;

@Controller
public class RecipeController {
	
	@Autowired
	private IngredientRepository ingredients;
	@Autowired
	private RecipeRepository recipes;
	@Autowired
	private ShelfRepository shelves;
	
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
		System.out.println(ingredients.someIngredientQuery());
		System.out.println(recipes.findAll());
		System.out.println(ingredients.flatIngredients());
		System.out.println(ingredients.ingredientByRecipeSortByShelf(10));
		System.out.println("----------------------------------");
		return "redirect:/shopping-by-recipe";
	}
	
	@GetMapping("/shopping-by-recipe/{id}")
	public ModelAndView viewShoppingList(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("viewShoppingList");
		List<Ingredient> ingredientsForRecipe = ingredients.ingredientByRecipeSortByShelf(id);
		System.out.println(ingredientsForRecipe);
//		System.out.println(recipes.findById(id));
//		List<Ingredient> ingredientsForRecipe = recipes.findIngredientsForRecipe(id);
//		System.out.println(ingredientsForRecipe);
		return modelAndView;
	}

}
