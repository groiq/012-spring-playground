package playground.spring.shoppingByRecipe.dbViewObjects;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import playground.spring.shoppingByRecipe.entities.Ingredient;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Immutable
@Subselect("select shelf.id, shelf.name, shelf.position, ingredient.name as ingredient "
		+ "from ingredient join shelf join recipe_ingredients "
		+ "where recipe_ingredients.recipe_id = :recipeId "
		+ "and recipe_ingredients.ingredients_id = ingredient.id "
		+ "and ingredient.shelf_id = shelf.id "
		+ "order by shelf.position")
public class ShoppingShelf {

	@Id
	@GeneratedValue
	private int id;
	
	@NonNull
	private String name;
	
	@NonNull
	private int position;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "shelf_id")
	private Set<Ingredient> ingredients;
	
}
