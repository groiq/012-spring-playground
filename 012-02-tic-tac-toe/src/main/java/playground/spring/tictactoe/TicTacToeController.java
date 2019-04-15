package playground.spring.tictactoe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicTacToeController {
	
	private String test = "hello";
	private int[][] boardData = new int[3][3];
	
	public TicTacToeController() {
		
	}
	
	@GetMapping("/tictactoe")
	ModelAndView ticTacToeBoard() {
		
		ModelAndView board = new ModelAndView("ticTacToe");
		board.addObject("boardData",boardData);
		
		
		return board;
	}

}
