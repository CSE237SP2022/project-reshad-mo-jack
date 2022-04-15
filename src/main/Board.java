package main;

public class Board {
	public char[][] board;
	public int dimension;

	public Board(int dimension) {
		board = new char[dimension][dimension];
	}

	public char[][] getBoard() {
		return board;
	}
	
	public int getDimension() {
		return board.length;
	}

	public int getNumRows() {
		return board[0].length;
	}

	public int getNumCols() {
		return board.length;
	}

	public int getEmptyRow(int col) {
		char[] column = board[col];
		int row = 0;
		while (column[row] != '\0') {
			row += 1;
		}
		return row;
	}

	public void addPieces(int col, char currentPlayerPiece) {
		int row = getEmptyRow(col);
		board[col][row] = currentPlayerPiece;
	}

	public boolean isVerticalWin() {
		int rows = getNumRows();
		int cols = getNumCols();

		for (int row = 0; row < rows - 3; row++) {
			for (int col = 0; col < cols; col++) {
				char piece = board[col][row];

				if (piece == '\0') {
					continue;
				}

				if (piece == board[col][row + 1] && piece == board[col][row + 2] && piece == board[col][row + 3]) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isHorizontalWin() {
		int rows = getNumRows();
		int cols = getNumCols();

		for (int col = 0; col < cols - 3; col++) {
			for (int row = 0; row < rows; row++) {
				char piece = board[col][row];

				if (piece == '\0') {
					continue;
				}

				if (piece == board[col + 1][row] && piece == board[col + 2][row] && piece == board[col + 3][row]) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isDiagonalWin() {
		if (checkBottomLeftTopRightDiagonal()) {
			return true;
		}

		if (checkTopLeftBottomRightDiagonal()) {
			return true;
		}

		return false;
	}

	public boolean checkBottomLeftTopRightDiagonal() {
		int rows = getNumRows();
		int cols = getNumCols();

		for (int col = 0; col < cols - 3; col++) {
			for (int row = 0; row < rows - 3; row++) {
				char piece = board[col][row];

				if (piece == '\0') {
					continue;
				}

				if (piece == board[col + 1][row + 1] && piece == board[col + 2][row + 2]
						&& piece == board[col + 3][row + 3]) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkTopLeftBottomRightDiagonal() {
		int rows = getNumRows();
		int cols = getNumCols();

		for (int col = cols - 1; col > 2; col--) {
			for (int row = 0; row < rows - 3; row++) {
				char piece = board[col][row];

				if (piece == '\0') {
					continue;
				}

				if (piece == board[col - 1][row + 1] && piece == board[col - 2][row + 2]
						&& piece == board[col - 3][row + 3]) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isTie() {
		int cols = getNumCols();
		int rows = getNumRows() - 1;

		for (int col = 0; col < cols; col++) {
			if (board[col][rows] == '\0') {
				return false;
			}
		}
		return true;
	}
}
