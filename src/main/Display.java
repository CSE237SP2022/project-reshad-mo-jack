package main;

public class Display {
	String frontSpacing = "   ";
	String spacingAfterLabel = "  ";
	String cellBorderSide = "|";

	public void printGame(String currentPlayer, char[][] board) {
		System.out.println();
		System.out.println("Current Player: " + currentPlayer);
		printBoard(board.length, board);
		System.out.println("----------------------------------");
	}

	public void printBoard(int boardDimension, char[][] board) {
		printHorizontalLine(boardDimension);
		printRow(boardDimension, board);
		printColumnLabel(boardDimension);
	}

	public void printHorizontalLine(int boardDimension) {
		String cellBorderTopOrBottom = "--";
		String cellBorderTopOrBottomEdge = "-";

		System.out.print(frontSpacing);
		System.out.print(cellBorderTopOrBottomEdge);
		for (int r = boardDimension - 1; r >= 0; r--) {
			System.out.print(cellBorderTopOrBottom);
		}
		System.out.println();
	}

	public void printRow(int boardDimension, char[][] board) {
		for (int r = boardDimension - 1; r >= 0; r--) {
			System.out.print((r + 1) + spacingAfterLabel + cellBorderSide);
			for (int c = 0; c < boardDimension; c++) {
				printPiece(board[c][r]);
			}
			System.out.println();
			printHorizontalLine(boardDimension);
		}
	}

	public void printPiece(char piece) {
		if (piece != '\0') {
			System.out.print(piece + cellBorderSide);
		} else {
			System.out.print(' ' + cellBorderSide);
		}
	}

	public void printColumnLabel(int boardDimension) {
		String columnLabelFrontSpacing = "    ";
		String spacingBetweenColumnLabels = " ";
		System.out.print(columnLabelFrontSpacing);
		for (int c = 1; c <= boardDimension; c++) {
			System.out.print(c + spacingBetweenColumnLabels);
		}
		System.out.println();
	}

	public void printGameEndStatus(boolean tie, String playerName) {
		if (tie) {
			System.out.println("The game was a tie!");
		} else {
			System.out.println("Congrats! " + playerName + " won the game.");
		}
	}
}
