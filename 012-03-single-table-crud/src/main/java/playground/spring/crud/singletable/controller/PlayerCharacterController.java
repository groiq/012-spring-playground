package playground.spring.crud.singletable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import playground.spring.crud.singletable.dao.PlayerCharacterRepository;

@Controller
public class PlayerCharacterController {
	
	@Autowired
	PlayerCharacterRepository repo;
	
	@GetMapping("/")
	public String listPlayerCharacters(Model theModel) {
		
		theModel.addAttribute("characters",repo.findAll());
		
		return "singleTable.html";
	}

}
