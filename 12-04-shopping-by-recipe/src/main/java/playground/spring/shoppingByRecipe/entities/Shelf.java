package playground.spring.shoppingByRecipe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Shelf {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;

}
