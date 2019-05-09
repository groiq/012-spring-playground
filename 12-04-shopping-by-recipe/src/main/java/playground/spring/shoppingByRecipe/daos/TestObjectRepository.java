package playground.spring.shoppingByRecipe.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import playground.spring.shoppingByRecipe.entities.TestObject;

public interface TestObjectRepository extends JpaRepository<TestObject, Integer> {

}
