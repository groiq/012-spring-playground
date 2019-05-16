package playground.spring.shoppingByRecipe.dbViewObjects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//@NoRepositoryBean
public interface FlatIngredientRepository extends JpaRepository<FlatIngredient, Integer> {

	
	
}
