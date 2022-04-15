package main;

import java.util.Scanner;

public class Input {
	public Scanner scanner;

	public Input() {
		this.scanner = new Scanner(System.in);
	}

	public String getInputValidPlayerName(int playerNumber) {
		String playerName = "";
		System.out.println("Enter username for player " + (playerNumber + 1));
		while (playerName.trim().length() == 0) {
			if (scanner.hasNextLine()) {
				playerName = this.scanner.nextLine();
			} else {
				System.out.println("Please enter non empty string for player name");
			}
		}
		return playerName;
	}

	public int getInputBoardDimension() {
		System.out.println("Enter dimensions for board");
		int dimension = 0;
		while ((dimension < 4) || (dimension > 10)) {
			try {
				System.out.println("Enter valid integer column between 4 and 10 for board dimensions");
				dimension = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Incorrect input: not an integer or valid dimension");
				scanner.nextLine();
			}

		}
		return dimension;
	}

	public int getInputValidColumn(int dimension, char[][] board) {
		int col = 0;
		while ((col < 1) || (col > dimension) || (board[col - 1][dimension - 1] != '\0')) {
			try {
				System.out.println("Enter valid integer column between 1 and " + dimension + " to place piece");
				col = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Incorrect input: not an integer or valid move");
				scanner.nextLine();
			}

		}
		return col - 1;
	}
}
