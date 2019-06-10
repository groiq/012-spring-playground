package playground.spring.shoppingByRecipe.dbViewObjects;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IngredientInShelfRepository extends JpaRepository<IngredientInShelf, Integer> {
	
	@Query(value = "select ingredient.id, ingredient.name, shelf.name as shelf, shelf.position "
			+ "from ingredient join shelf join recipe_ingredients "
			+ "where recipe_ingredients.recipe_id = :recipeId "
			+ "and recipe_ingredients.ingredients_id = ingredient.id "
			+ "and ingredient.shelf_id = shelf.id "
			+ "order by shelf.position", nativeQuery = true)
	public List<IngredientInShelf> shoppingListFor(@Param("recipeId") int recipeId);

}
