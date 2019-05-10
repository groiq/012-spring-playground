package playground.spring.shoppingByRecipe.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Shelf {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NonNull
	private String name;
	
	/*
	 * Position of the shelf in the store.
	 * 
	 * I'll just assume that the arrangement of shelves in the store is implemented once and then unchanged.
	 * So no need for a linked list.
	 * I'll just use the position field to handle sorting during database lookup.
	 */
	@NonNull
	private int position;
	
	@OneToMany(mappedBy = "shelf")
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	/*
	 * Relation between shelf and ingredient is bidirectional for practicing purposes.
	 * Arguably unneccessary because looking up the contents of a shelf is not a basic functionality.
	 */

}
