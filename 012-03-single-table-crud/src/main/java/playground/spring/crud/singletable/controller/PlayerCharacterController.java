package playground.spring.crud.singletable.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class PlayerCharacterController {
	
	@GetMapping("/")
	public String listPlayerCharacters(Model theModel) {
		
		return "index.html";
	}

}
