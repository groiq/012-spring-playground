package playground.spring.shoppingByRecipe.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import playground.spring.shoppingByRecipe.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
