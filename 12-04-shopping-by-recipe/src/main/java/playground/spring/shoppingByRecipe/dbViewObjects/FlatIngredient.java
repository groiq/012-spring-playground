package playground.spring.shoppingByRecipe.dbViewObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Immutable
@Subselect(
		"select ingredient.id, ingredient.name, shelf.name as shelf "
		+ "from ingredient join shelf "
		+ "on ingredient.shelf_id = shelf.id"
		)
public class FlatIngredient {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NonNull
	private String name;

	@NonNull
	private String shelf;

}
