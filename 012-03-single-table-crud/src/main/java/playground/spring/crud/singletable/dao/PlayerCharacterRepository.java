package playground.spring.crud.singletable.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import playground.spring.crud.singletable.entity.PlayerCharacter;

public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter,Integer> {
	
	// some methods for sorting
	//public List<PlayerCharacter> findAllOrderByNameAsc();

}
