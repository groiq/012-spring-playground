package playground.spring.shoppingByRecipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipeController {
	
	@GetMapping("/shopping-by-recipe")
	public ModelAndView shoppingByRecipe() {
		ModelAndView modelAndView = new ModelAndView("shoppingByRecipe");
		
		return modelAndView;
	}

}
