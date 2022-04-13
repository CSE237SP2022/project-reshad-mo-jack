package main;

import java.util.Scanner;

public class ConnectFour {
	// 0 no piece, player 1 is 1, player 2 is 2
	public char[][] board;
	public Scanner scanner;
	public int currentTurnPlayer;
	public String[] players;
	public char[] playerPieces;

	public static void main(String[] args) {
		char[][] board = new char[8][8];
		Scanner scanner = new Scanner(System.in);
		ConnectFour game = new ConnectFour(board, scanner);
		game.play();
	}

	public ConnectFour(char[][] board, Scanner scanner) {
		this.board = board;
		this.scanner = scanner;
		this.currentTurnPlayer = 0;
		this.players = new String[2];
		this.playerPieces = new char[] { 'X', 'O' };
	}

	public void play() {
		setPlayerNames();
		printGame();

		while (true) {
			int col = inputValidColumn();
			addPieces(col);
			changeTurns();
			printGame();
		}
	}

	public int getNumRows() {
		return board[0].length;
	}

	public int getNumCols() {
		return board.length;
	}

	public void setPlayerNames() {
		for (int playerNumber = 0; playerNumber < 2; playerNumber++) {
			System.out.println("Enter username for player " + (playerNumber + 1));
			players[playerNumber] = inputValidPlayerName();
		}
	}
	

	public String inputValidPlayerName() {
		String playerName = "";
		while (playerName.trim().length() == 0) {
			if (scanner.hasNextLine()) {
				playerName = this.scanner.nextLine();
			} else {
				System.out.println("Please enter non empty string for player name");
			}
		}
		return playerName;
	}

	public String[] getPlayerNames() {
		return players;
	}
	
	public int inputValidColumn() {
		int col = 0;
		int columns = getNumCols();
		while ((col < 1) || (col > 8) || (board[col - 1][7] != '\0')) {
			try {
				System.out.println("Enter valid integer column between 1 and " + columns + " to place piece");
				col = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Incorrect input: not an integer or valid move");
	            scanner.nextLine();
			}

		}
		return col - 1;
	}

	public void addPieces(int col) {
		int row = getEmptyRow(col);
		board[col][row] = getCurrentPlayerPiece();
	}
	
	public char getCurrentPlayerPiece() {
		 return playerPieces[currentTurnPlayer];
	}

	public int getEmptyRow(int col) {
		char[] column = board[col];
		int row = 0;
		while (column[row] != '\0') {
			row += 1;
		}
		return row;
	}

	public int gameWon() {
		return 0;
	}

	public void changeTurns() {
		if (currentTurnPlayer == 0) {
			currentTurnPlayer = 1;
		} else {
			currentTurnPlayer = 0;
		}
	}

	public void printGame() {
		System.out.println("Current Player: " + players[currentTurnPlayer]);
		printBoard();
	}

	public void printBoard() {
		String frontSpacing = "   ";

		System.out.println();
		printHorizontalLine(frontSpacing);
		printRow(frontSpacing);
		printColumnLabel();
	}

	public void printHorizontalLine(String frontSpacing) {
		int rows = getNumRows();
		String cellBorderTopOrBottom = "--";
		String cellBorderTopOrBottomEdge = "-";

		System.out.print(frontSpacing);
		System.out.print(cellBorderTopOrBottomEdge);
		for (int r = rows - 1; r >= 0; r--) {
			System.out.print(cellBorderTopOrBottom);
		}
		System.out.println();
	}

	public void printRow(String frontSpacing) {
		int rows = getNumRows();
		int cols = getNumCols();
		String spacingAfterLabel = "  ";
		String cellBorderSide = "|";

		for (int r = rows - 1; r >= 0; r--) {
			System.out.print((r + 1) + spacingAfterLabel + cellBorderSide);
			for (int c = 0; c < cols; c++) {
				if(board[c][r] != '\0') {
					System.out.print(board[c][r] + cellBorderSide);
				} else {
					System.out.print(' ' + cellBorderSide);
				}
			}
			System.out.println();
			printHorizontalLine(frontSpacing);
		}
	}

	public void printColumnLabel() {
		int cols = getNumCols();
		String frontSpacing = "    ";
		String spacingBetweenColumnLabels = " ";

		System.out.print(frontSpacing);
		for (int c = 1; c <= cols; c++) {
			System.out.print(c + spacingBetweenColumnLabels);
		}

		System.out.println();
	}

}