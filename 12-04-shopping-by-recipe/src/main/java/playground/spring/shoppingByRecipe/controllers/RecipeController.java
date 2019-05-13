package playground.spring.shoppingByRecipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import playground.spring.shoppingByRecipe.daos.IngredientRepository;
import playground.spring.shoppingByRecipe.daos.RecipeRepository;
import playground.spring.shoppingByRecipe.daos.ShelfRepository;
import playground.spring.shoppingByRecipe.entities.Ingredient;
import playground.spring.shoppingByRecipe.entities.Recipe;
import playground.spring.shoppingByRecipe.entities.Shelf;

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
		
		return modelAndView;
	}
	
	/*
	 * if database is empty, fill in some data.
	 */
	@GetMapping("/shopping-by-recipe/fill")
	public String autofill() {
		if (recipes.count() == 0) {
			
			String[] shelfNames = {"vegetables","side dishes","dairy"};
			String[] ingredientNames = {"papric","rice","sour cream"};
			String[] recipeNames = {"duvec","potato sauce","risotto"};
			
			Shelf[] shelves = new Shelf[3];
			Ingredient[] ingredients = new Ingredient[3];
			Recipe[] recipes = new Recipe[3];
			
			for (int i = 0; i < recipes.length; i++) {
				
				shelves[i] = new Shelf(shelfNames[i], i);
				ingredients[i] = new Ingredient(ingredientNames[i], shelves[i]);
				
				recipes[i] = new Recipe(recipeNames[i]);
			}
			
			recipes[0].getIngredients().add(ingredients[0]);
			recipes[0].getIngredients().add(ingredients[1]);
			recipes[1].getIngredients().add(ingredients[0]);
			recipes[1].getIngredients().add(ingredients[2]);
			recipes[2].getIngredients().add(ingredients[1]);
			recipes[2].getIngredients().add(ingredients[2]);

			for (int i = 0; i < recipes.length; i++) {
				this.shelves.save(shelves[i]);
				this.ingredients.save(ingredients[i]);
//				this.recipes.save(recipes[i]);
			}
			for (int i = 0; i < recipes.length; i++) {
				this.recipes.save(recipes[i]);
			}
			

			
		}
		return "redirect:/shopping-by-recipe";
	}

}
