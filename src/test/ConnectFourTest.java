package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import main.Board;
import main.ConnectFour;
import main.Player;

public class ConnectFourTest {
	private ConnectFour game;

	@BeforeEach
	public void setup() {
		game = new ConnectFour();
		game.players[0]  = new Player("Player1", 'X');
		game.players[1] = new Player("Player2", 'O');
	}
	
	@Test
	public void testConnectFourConstructor() {
		int currentTurnPlayer = 0;
		assertEquals(currentTurnPlayer, game.currentTurnPlayer);
	}
	
	@Test
	public void testConnectFourConstructorShouldFail() {
		int currentTurnPlayer = 1;
		assertNotEquals(currentTurnPlayer, game.currentTurnPlayer);
	}

	@Test
	public void testGetCurrentPlayerName() {
		String playerName = "Player1";
		assertTrue(playerName.equals(game.getCurrentPlayerName()));
	}
	
	@Test
	public void testGetCurrentPlayerNameShouldFail() {
		String playerName = "Player2";
		assertFalse(playerName.equals(game.getCurrentPlayerName()));
	}

	@Test
	public void testGetCurrentPlayerPiece() {
		char piece = game.getCurrentPlayerPiece();
		assertEquals('X', piece);
	}

	@Test
	public void testGetCurrentPlayerPieceShouldFail() {
		char piece = game.getCurrentPlayerPiece();
		assertNotEquals('O', piece);
	}

	@Test
	public void testGetCurrentPlayerPieceChangeTurn() {
		game.changeTurns();
		char piece = game.getCurrentPlayerPiece();
		assertEquals('O', piece);
	}

	@Test
	public void testGetCurrentPlayerPieceChangeTurnShouldFail() {
		game.changeTurns();
		char piece = game.getCurrentPlayerPiece();
		assertNotEquals('X', piece);
	}

	@Test
	public void testChangeTurnsInitial() {
		assertEquals(0, game.currentTurnPlayer);
	}

	@Test
	public void testChangeTurnsInitialShouldFail() {
		assertNotEquals(1, game.currentTurnPlayer);
	}

	@Test
	public void testChangeTurns() {
		game.changeTurns();
		assertEquals(1, game.currentTurnPlayer);
	}

	@Test
	public void testChangeTurnsShouldFail() {
		game.changeTurns();
		assertNotEquals(0, game.currentTurnPlayer);
	}

	@Test
	public void testChangeTurnsMultiple() {
		for (int i = 0; i < 2; i++) {
			game.changeTurns();
		}

		assertEquals(0, game.currentTurnPlayer);
	}

	@Test
	public void testChangeTurnsMultipleShouldFail() {
		for (int i = 0; i < 3; i++) {
			game.changeTurns();
		}
		assertNotEquals(0, game.currentTurnPlayer);
	}
	
	@Test
	public void testIsGameEnd() {
		int dimension = 4;
		char[][] board = new char[dimension][dimension];
		for(int c = 0; c<dimension; c++) {
			board[c][0] = 'X';
		}
		game.boardObj = new Board(4);
		game.boardObj.board = board;
		assertTrue(game.isGameEnd());
	}
	
	
	@Test
	public void testIsGameEndShouldFail() {
		game.boardObj = new Board(4);
		assertFalse(game.isGameEnd());
	}

}
