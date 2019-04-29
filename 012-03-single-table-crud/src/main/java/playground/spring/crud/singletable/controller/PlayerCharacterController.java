package playground.spring.crud.singletable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import playground.spring.crud.singletable.dao.PlayerCharacterRepository;
import playground.spring.crud.singletable.entity.PlayerCharacter;

@Controller
public class PlayerCharacterController {
	
	@Autowired
	PlayerCharacterRepository repo;
	
//	@PostMapping("/autofill")
//	public String autofill(Model theModel) {
//		
//		repo.save(new PlayerCharacter("Gavin","human","warrior"));
//		
////		return listPlayerCharacters(theModel);
//		return "playerCharacters";
//	}
	
	@GetMapping("/")
//	public ModelAndView listPlayerCharacters() {
//		ModelAndView modelAndView = new ModelAndView("playerCharacters");
//		modelAndView.addObject("theCharacters",repo.findAll());
//		return modelAndView;
//	}
	public String listPlayerCharacters(Model theModel) {
		theModel.addAttribute("theCharacters", repo.findAll());
		return "playerCharacters";
	}

}
