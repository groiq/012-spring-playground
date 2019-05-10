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
	
}
