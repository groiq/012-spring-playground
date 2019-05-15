package playground.spring.shoppingByRecipe.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import playground.spring.shoppingByRecipe.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
	
	@Query(value = "select * from ingredient i where i.shelf_id = 1", nativeQuery = true)
	public List<Ingredient> someIngredientQuery();
	
	@Query(value = "select ingredient.* from ingredient join shelf " + 
			"where ingredient.shelf_id = shelf.id and shelf.name = 'vegetables'", nativeQuery = true)
	public List<Ingredient> flatIngredients();
	
	@Query(value = "select ingredient.* from ingredient join shelf join recipe_ingredients "
			+ "where recipe_ingredients.recipe_id = :recipeId "
			+ "and recipe_ingredients.ingredients_id = ingredient.id "
			+ "and ingredient.shelf_id = shelf.id order by shelf.position", nativeQuery = true)
	public List<Ingredient> ingredientByRecipeSortByShelf(@Param("recipeId") int recipeId);
	
	

}
