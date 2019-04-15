package playground.spring.tictactoe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicTacToeController {
	
	@GetMapping("/tictactoe")
	ModelAndView ticTacToeBoard() {
		
		ModelAndView board = new ModelAndView("ticTacToe");
		
		return board;
	}

}
