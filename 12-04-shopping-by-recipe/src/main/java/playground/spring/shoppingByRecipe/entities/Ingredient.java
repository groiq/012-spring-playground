package playground.spring.shoppingByRecipe.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Ingredient {

	@Id
	@GeneratedValue
	private int id;
	
	@NonNull
	private String name;
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shelf_id")
	private Shelf shelf;

//	public String toString() {
//		String result;
////		result = "this is an ingredient toString()";
//		result = this.getId() + ": " + this.getName() + " on shelf " + this.getShelf().getName();
//		return result;
//	}

	
}
