package playground.spring.tictactoe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicTacToeController {
	
	private int[][] boardData = new int[3][3];
	
	public TicTacToeController() {
		int counter = 0;
		for (int i = 0; i < boardData.length; i++) {
			for (int j = 0; j < boardData[i].length; j++) {
				boardData[i][j] = counter;
				counter++;
			}
		}
	}
	
	@GetMapping("/tictactoe")
	ModelAndView ticTacToeBoard() {
		
		ModelAndView board = new ModelAndView("ticTacToe");
		board.addObject("boardData",boardData);
		
		
		return board;
	}

}