package playground.spring.crud.singletable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	private void autofill() {
		repo.save(new PlayerCharacter("Gavin","human","warrior"));
		repo.save(new PlayerCharacter("Gylfi","norn","guardian"));
		repo.save(new PlayerCharacter("Chlegg","asura","necromancer"));
	}
	
	@GetMapping("/")
//	public ModelAndView listPlayerCharacters() {
//		ModelAndView modelAndView = new ModelAndView("playerCharacters");
//		modelAndView.addObject("theCharacters",repo.findAll());
//		return modelAndView;
//	}
	public String listPlayerCharacters(Model theModel) {
		List<PlayerCharacter> theCharacters = repo.findAll();
		String dbStatus;
		if (theCharacters.isEmpty()) {
			dbStatus = "found empty and autofilled";
			autofill();
			theCharacters = repo.findAll();
		} else {
			dbStatus = "found filled";
		}
		theModel.addAttribute("theCharacters", theCharacters);
		theModel.addAttribute("dbStatus", dbStatus);
		return "playerCharacters";
	}

}
