package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.TestFactory;

import main.ConnectFour;

public class ConnectFourTest {
	private ConnectFour game;

	@Before
	void setup() {
		int[][] board = new int[8][8];
		Scanner scanner = new Scanner(System.in);
		game = new ConnectFour(board, scanner);
	}

	@Test
	void addPieceBelowBoard() {
		boolean wasValid = game.validMove(0);
		assertEquals(wasValid, false);
	}

	@Test
	void addPiecePastBoard() {
		boolean wasValid = game.validMove(9);
		assertEquals(wasValid, false);
	}

	@Test
	void addNames() {
		String input = "name1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		// System.setIn(in);
		game.playerNames(game.scanner, "1");
		assertTrue("name1".equals(game.getPlayerNames()[0]));
	}

	@Test
	void wrongNames() {
		String input = "name2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		// System.setIn(in);
		game.playerNames(game.scanner, "2");
		assertFalse("name2".equals(game.getPlayerNames()[1]));
	}

	@Test
	void horizonalWin() {
        game.board[3][0] = 1;
        game.board[2][0] = 1;
        game.board[1][0] = 1;
        game.board[0][0] = 1;
		assertTrue(game.gameWon());
	}

	@Test
	void verticalWin() {
		game.board[0][4] = 1;
        game.board[0][3] = 1;
        game.board[0][2] = 1;
        game.board[0][1] = 1;
		assertTrue(game.gameWon());
	}

	@Test
	void diagnolWin() {
		game.board[4][4] = 1;
        game.board[5][3] = 1;
        game.board[6][2] = 1;
        game.board[7][1] = 1;
		assertTrue(game.gameWon());
	}

	@Test
	void diagnolWin2() {
		game.board[0][0] = 1;
        game.board[2][2] = 1;
        game.board[3][3] = 1;
        game.board[1][1] = 1;
		assertTrue(game.gameWon());
	}

	@Test
	void tied() {
		int colSize = game.board[0].length;
        for(int col = 0; col < colSize; col ++) {
            game.board[7][col] = 1;
        }
		assertTrue(game.gameTie());
	}
}
