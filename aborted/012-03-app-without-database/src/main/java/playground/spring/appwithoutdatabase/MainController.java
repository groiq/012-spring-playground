package playground.spring.appwithoutdatabase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/index")
	ModelAndView index() {
		
		ModelAndView ticTacToeLobby = new ModelAndView("ticTacToeLobby");
		
		return ticTacToeLobby;
		
	}
	
}
