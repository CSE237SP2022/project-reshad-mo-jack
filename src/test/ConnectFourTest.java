package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import main.ConnectFour;

public class ConnectFourTest {
	private ConnectFour game;

	@Before
	public void setup() {
		char[][] board = new char[8][8];
		Scanner scanner = new Scanner(System.in);
		game = new ConnectFour(board, scanner);
	}

	@Test
	public void testGetNumRows() {
		int rows = game.getNumRows();
		assertEquals(rows, 8);
	}

	@Test
	public void testGetNumRowsShouldFail() {
		int rows = game.getNumRows();
		assertNotEquals(rows, 1);
	}

	@Test
	public void testGetNumCols() {
		int cols = game.getNumCols();
		assertEquals(cols, 8);
	}

	@Test
	public void testGetNumColsShouldFail() {
		int cols = game.getNumCols();
		assertNotEquals(cols, 3);
	}

	@Test
	public void testGetPlayerNamesEmpty() {
		String[] playerNames = { null, null };
		assertArrayEquals(game.players, playerNames);
	}
	
	@Test
	public void testAddPieces() {
		char[][] board = new char[8][8];
		char piece = game.getCurrentPlayerPiece();
		board[5][0] = piece;
		
		game.addPieces(5);		
		assertArrayEquals(board, game.board);
	}
	
	@Test
	public void testAddPiecesShouldFail() {
		char[][] board = new char[8][8];
		char piece = game.getCurrentPlayerPiece();
		board[5][0] = piece;
		
		game.addPieces(7);		
		assertFalse(Arrays.equals(board, game.board));
	}
	
	@Test
	public void testAddPiecesMultiplePieces() {
		char[][] board = new char[8][8];
		char piece = game.getCurrentPlayerPiece();
		board[3][0] = piece;
		
		game.addPieces(3);
		
		piece = game.getCurrentPlayerPiece();
		board[3][1] = piece;
		
		game.addPieces(3);

		assertArrayEquals(board, game.board);
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
		assertEquals('X', piece);
	}
	
	@Test
	public void testGetEmptyRow() {
		int row = game.getEmptyRow(0);
		assertEquals(0, row);
	}
	
	@Test
	public void testGetEmptyRowShouldFail() {
		int row = game.getEmptyRow(0);
		assertNotEquals(1, row);
	}
	
	@Test
	public void testGetEmptyRowWithPieces() {
		game.addPieces(0);
		game.addPieces(0);
		int row = game.getEmptyRow(0); 
		assertEquals(2, row);
	}
	
	@Test
	public void testGetEmptyRowWithPiecesShouldFail() {
		game.addPieces(0);
		game.addPieces(1);
		int row = game.getEmptyRow(0); 
		assertNotEquals(3, row);
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
		for(int i=0; i<2; i++) {
			game.changeTurns();
		}

		assertEquals(0, game.currentTurnPlayer);
	}
	
	@Test
	public void testChangeTurnsMultipleShouldFail() {
		for(int i=0; i<3; i++) {
			game.changeTurns();
		}
		assertNotEquals(0, game.currentTurnPlayer);
	}

}
