package playground.spring.shoppingByRecipe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Recipe {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NonNull
	private String name;

}
