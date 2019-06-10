package playground.spring.shoppingByRecipe.dbViewObjects;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientInShelfRepository extends JpaRepository<IngredientInShelf, Integer> {

}
