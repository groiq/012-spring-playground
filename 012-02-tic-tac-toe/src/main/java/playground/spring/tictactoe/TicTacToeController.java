package playground.spring.tictactoe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicTacToeController {
	
	private int[][] boardData = new int[3][3];
	private String status = "open";

	private boolean checkBoard(int row, int col) {
		
		boolean won = false;
		int player = boardData[row][col];
		
		// check for a win
		boolean sameRow = true;
		boolean sameCol = true;
		boolean rising = true;
		boolean falling = true;
		for (int i = 0; i < boardData.length; i++) {
			if (boardData[row][i] != player) {
				sameRow = false;
			}
			if (boardData[i][col] != player) {
				sameCol = false;
			}
			if (boardData[i][i] != player) {
				rising = false;
			}
			if (boardData[i][2-i] != player)
				falling = false;
		}
		if (sameRow || sameCol || rising || falling) {
			won = true;
		}
		
		// check for a draw (i.e. a full board)
		boolean draw = true;
		outer: for (int i = 0; i < boardData.length; i++) {
			for (int j = 0; j < boardData[i].length; j++) {
				if (boardData[i][j] == 0) {
					draw = false;
					break outer;
				}
			}
		}
		if (draw) { status = "draw"; }
		
		return won;
		
	}
	
	private void computerMoves() {
		outer: for (int i = 0; i < boardData.length; i++) {
			for (int j = 0; j < boardData[i].length; j++) {
				if (boardData[i][j] == 0) {
					boardData[i][j] = 2;
					if (checkBoard(i,j)) {
						status = "computer";
					}
					break outer;
				}
			}
		}
	}

	@GetMapping("/tictactoe/{row}/{col}")
	ModelAndView processMove(@PathVariable int row, @PathVariable int col) {
		// for later: check whether this position is already filled, this will prevent glitches.
		boardData[row][col] = 1;
		if (checkBoard(row,col)) {
			status = "user";
		} else {
			computerMoves();
		}
		return ticTacToeBoard();
	}
	
	@GetMapping("/tictactoe")
	ModelAndView resetGame() {
		status = "open";
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
		board.addObject("status",status);
		return board;
	}

}
