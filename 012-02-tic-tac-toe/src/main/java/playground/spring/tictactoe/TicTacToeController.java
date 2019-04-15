package playground.spring.tictactoe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicTacToeController {
	
	private int[][] boardData = new int[3][3];

	private void checkBoard(int row, int col) {
		
		// check for a win
		
		
		// check for a draw
		
	}
	
	private void computerMoves() {
		
		for (int i = 0; i < boardData.length; i++) {
			for (int j = 0; j < boardData[i].length; j++) {
				if (boardData[i][j] == 0) {
					boardData[i][j] = 2;
					checkBoard(i,j);
					return;
				}
			}
		}
		
	}

	@GetMapping("/tictactoe/{row}/{col}")
	ModelAndView processMove(@PathVariable int row, @PathVariable int col) {
		
		System.out.println(row + " + " + col + " = " + (row+col));
		
		boardData[row][col] = 1;
		
		checkBoard(row,col);
		
		computerMoves();
		
		
		// check if finished (won or draw)
		
		// computer makes his move
		
		// again check if finished
		
		return ticTacToeBoard();
	}
	
	@GetMapping("/tictactoe")
	ModelAndView resetGame() {
		
		for (int i = 0; i < boardData.length; i++) {
			for (int j = 0; j < boardData[i].length; j++) {
				boardData[i][j] = 0;
			}
		}
		
		return ticTacToeBoard();
	}
	
	ModelAndView ticTacToeBoard() {
		
		
		ModelAndView board = new ModelAndView("ticTacToe");
		board.addObject("boardData",boardData);
		
		
		return board;
	}

}
