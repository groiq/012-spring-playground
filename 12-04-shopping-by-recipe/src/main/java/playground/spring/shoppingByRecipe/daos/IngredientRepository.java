package playground.spring.shoppingByRecipe.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import playground.spring.shoppingByRecipe.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
	
	@Query(value = "select * from ingredient i where i.shelf_id = 1", nativeQuery = true)
	public List<Ingredient> someIngredientQuery();

}
