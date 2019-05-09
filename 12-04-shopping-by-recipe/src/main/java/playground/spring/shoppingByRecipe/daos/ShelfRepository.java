package playground.spring.shoppingByRecipe.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import playground.spring.shoppingByRecipe.entities.Shelf;

public interface ShelfRepository extends JpaRepository<Shelf, Integer> {

}
