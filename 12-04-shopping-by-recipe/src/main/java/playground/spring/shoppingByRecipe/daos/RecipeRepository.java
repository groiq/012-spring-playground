package playground.spring.shoppingByRecipe.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import playground.spring.shoppingByRecipe.entities.Ingredient;
import playground.spring.shoppingByRecipe.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
	
	

}
