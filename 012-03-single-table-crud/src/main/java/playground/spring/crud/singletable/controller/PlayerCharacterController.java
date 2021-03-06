package playground.spring.crud.singletable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import playground.spring.crud.singletable.dao.PlayerCharacterRepository;
import playground.spring.crud.singletable.entity.PlayerCharacter;

@Controller
public class PlayerCharacterController {
	
	@Autowired
	private PlayerCharacterRepository repo;
	
	private String dbStatus;
	
	private String lastActionMsg = "(no action message)";
	private void resetActionMsg() {
		lastActionMsg = "(no action message)";
	}
	
	private void checkDatabaseFilled() {
		if (repo.count() == 0) {
			repo.save(new PlayerCharacter("Gavin","human","warrior"));
			repo.save(new PlayerCharacter("Gylfi","norn","guardian"));
			repo.save(new PlayerCharacter("Chlegg","asura","necromancer"));
			dbStatus = "empty and autofilled";
		} else {
			dbStatus = "filled";
		}
	}
		
	@GetMapping("/")
	public ModelAndView listPlayerCharacters() {
		ModelAndView modelAndView = new ModelAndView("playerCharacters");
		checkDatabaseFilled();
		modelAndView.addObject("theCharacters", repo.findAll());
		modelAndView.addObject("dbStatus", dbStatus);
		modelAndView.addObject("lastActionMsg", lastActionMsg);
		resetActionMsg();
		return modelAndView;
	}
	
	@GetMapping("/{id}/delete")
	public String deleteCharacter(Model theModel, @PathVariable int id) {
		repo.deleteById(id);
		lastActionMsg = "Character deleted.";
		return "redirect:/";
	}
	
	@GetMapping("/create")
	public ModelAndView createCharacter() {
		lastActionMsg = "new character saved.";
		ModelAndView modelAndView = new ModelAndView("updateform");
		modelAndView.addObject("playerCharacter", new PlayerCharacter());
		return modelAndView;
	}
	
	@GetMapping("/{id}/update")
	public ModelAndView updateCharacter(@PathVariable int id) {
		lastActionMsg = "character updated.";
		ModelAndView modelAndView = new ModelAndView("updateform");
		PlayerCharacter thePlayerCharacter = repo.findById(id).get();
		modelAndView.addObject("playerCharacter", thePlayerCharacter);
		return modelAndView;
	}


	@PostMapping("/save")
	public String saveCharacter(PlayerCharacter theCharacter) {
		repo.save(theCharacter);
//		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return "redirect:/";
//		return modelAndView;
	}
}
