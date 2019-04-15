package playground.spring.tictactoe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicTacToeController {
	
	private int[][] boardData = new int[3][3];
	
	public TicTacToeController() {
		for (int i = 0; i < boardData.length; i++) {
			for (int j = 0; j < boardData[i].length; j++) {
				boardData[i][j] = (i+j) % 3;
			}
		}
	}
	
	@GetMapping("/tictactoe/{row}/{col}")
	ModelAndView processMove(@PathVariable int row, @PathVariable int col) {
		
		System.out.println(row + " + " + col + " = " + (row+col));
		
		boardData[row][col] = 1;
		
		// check if finished (won or draw)
		
		// computer makes his move
		
		// again check if finished
		
		return ticTacToeBoard();
	}
	
	@GetMapping("/tictactoe")
	ModelAndView ticTacToeBoard() {
		
		ModelAndView board = new ModelAndView("ticTacToe");
		board.addObject("boardData",boardData);
		
		
		return board;
	}

}
