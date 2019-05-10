package playground.spring.shoppingByRecipe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Ingredient {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@ManyToOne
	private Shelf shelf;
	
	public void setShelf(Shelf newShelf) {
		this.shelf.getIngredients().remove(this);
		// test whether that properly writes back to the field. (should do so, cause the getter fetches the *reference*.
		this.shelf = newShelf;
		newShelf.getIngredients().add(this);
	}
	
}
