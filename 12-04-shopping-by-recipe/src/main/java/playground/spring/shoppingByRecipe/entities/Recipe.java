package playground.spring.shoppingByRecipe.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Ingredient> ingredients = new HashSet<Ingredient>();

}
