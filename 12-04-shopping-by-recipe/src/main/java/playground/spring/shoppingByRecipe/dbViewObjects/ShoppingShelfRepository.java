package playground.spring.shoppingByRecipe.dbViewObjects;

//import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import playground.spring.shoppingByRecipe.entities.Ingredient;

public interface ShoppingShelfRepository extends JpaRepository<ShoppingShelf, Integer> {

//	@Query(value = "select ingredient.* from ingredient join shelf join recipe_ingredients "
//			+ "where recipe_ingredients.recipe_id = :recipeId "
//			+ "and recipe_ingredients.ingredients_id = ingredient.id "
//			+ "and ingredient.shelf_id = shelf.id "
//			+ "order by shelf.position", nativeQuery = true)
//	public List<Ingredient> ingredientByRecipeSortByShelf(@Param("recipeId") int recipeId);
//	

	@Query(value = "select shelf.id, shelf.name, shelf.position, ingredient.name as ingredient "
			+ "from ingredient join shelf join recipe_ingredients "
			+ "where recipe_ingredients.recipe_id = :recipeId "
			+ "and recipe_ingredients.ingredients_id = ingredient.id "
			+ "and ingredient.shelf_id = shelf.id "
			+ "order by shelf.position", nativeQuery = true)
	public Set<ShoppingShelf> shoppingListFor(@Param("recipeId") int recipeId); 
	
}
