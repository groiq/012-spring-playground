package playground.spring.shoppingByRecipe.dbViewObjects;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

//@NoRepositoryBean
public interface FlatShelfRepository extends JpaRepository<FlatShelf, Integer> {
	
	@Query(value = "select shelf.id, shelf.name, shelf.position, ingredient.name as ingredient "
			+ "from ingredient join shelf "
			+ "on ingredient.shelf_id = shelf.id", nativeQuery = true)
	public Set<FlatShelf> findFlatShelves();
	
//	@Query(value = "", nativeQuery = true)
//	public Set<FlatShelf> findByRecipe();
	

}
