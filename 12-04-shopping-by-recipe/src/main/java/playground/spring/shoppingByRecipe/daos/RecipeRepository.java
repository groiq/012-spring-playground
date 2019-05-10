package playground.spring.shoppingByRecipe.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import playground.spring.shoppingByRecipe.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}
