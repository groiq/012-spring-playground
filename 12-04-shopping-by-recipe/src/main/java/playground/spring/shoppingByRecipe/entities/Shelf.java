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
	
	@OneToMany(mappedBy = "shelf")
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();

}
