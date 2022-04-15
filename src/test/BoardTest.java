package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Board;

class BoardTest {
	private Board boardObj;
	private char[][] board;

	@BeforeEach
	public void setup() {
		int setupDimension = 8;
		boardObj = new Board(setupDimension);
		board = new char[setupDimension][setupDimension];
	}
	
	@Test
	public void testBoardConstructor() {
		assertArrayEquals(board, boardObj.board);
	}
	
	@Test
	public void testBoardConstructorShouldFail() {
		char[][] testBoard = new char[7][7];
		assertNotEquals(testBoard, boardObj.board);
	}
	
	@Test
	public void testGetBoard() {
		assertArrayEquals(board, boardObj.getBoard());
	}
	
	@Test
	public void testGetBoardShouldFail() {
		char[][] testBoard = new char[7][7];
		assertNotEquals(testBoard, boardObj.getBoard());
	}
	
	@Test
	public void testGetDimension() {
		assertEquals(board.length, boardObj.getDimension());
	}
	
	@Test
	public void testGetDimensionShouldFail() {
		char[][] testBoard = new char[7][7];
		assertNotEquals(testBoard.length, boardObj.getDimension());
	}

	@Test
	public void testGetNumRows() {
		int rows = boardObj.getNumRows();
		assertEquals(rows, 8);
	}

	@Test
	public void testGetNumRowsShouldFail() {
		int rows = boardObj.getNumRows();
		assertNotEquals(rows, 1);
	}

	@Test
	public void testGetNumCols() {
		int cols = boardObj.getNumCols();
		assertEquals(cols, 8);
	}

	@Test
	public void testGetNumColsShouldFail() {
		int cols = boardObj.getNumCols();
		assertNotEquals(cols, 3);
	}
	
	@Test
	public void testAddPieces() {
		char[][] board = new char[8][8];
		char piece = 'X';
		board[5][0] = piece;
		
		boardObj.addPieces(5, piece);	
		
		assertArrayEquals(board, boardObj.board);
	}
	
	@Test
	public void testGetEmptyRow() {
		int row = boardObj.getEmptyRow(0);
		assertEquals(0, row);
	}
	
	@Test
	public void testGetEmptyRowShouldFail() {
		int row = boardObj.getEmptyRow(0);
		assertNotEquals(1, row);
	}
	
	@Test
	public void testGetEmptyRowWithPieces() {
		boardObj.addPieces(0, 'X');
		boardObj.addPieces(0, 'O');
		int row = boardObj.getEmptyRow(0); 
		assertEquals(2, row);
	}
	
	@Test
	public void testGetEmptyRowWithPiecesShouldFail() {
		boardObj.addPieces(0, 'X');
		boardObj.addPieces(1, 'O');
		int row = boardObj.getEmptyRow(0); 
		assertNotEquals(3, row);
	}
	
	@Test
	public void testAddPiecesShouldFail() {
		char[][] board = new char[8][8];
		char piece = 'X';
		board[5][0] = piece;
		
		boardObj.addPieces(7, piece);
		
		assertFalse(Arrays.equals(board, boardObj.board));
	}
	
	@Test
	public void testAddPiecesMultiplePieces() {
		char[][] board = new char[8][8];
		char piece = 'X';
		board[3][0] = piece;
		
		boardObj.addPieces(3, piece);
		
		piece = 'O';
		board[3][1] = piece;
		
		boardObj.addPieces(3, piece);

		assertArrayEquals(board, boardObj.board);
	}
	
	@Test
	public void testAddPiecesMultiplePiecesShouldFail() {
		char[][] board = new char[8][8];
		char piece = 'X';
		board[3][0] = piece;
		boardObj.addPieces(3, piece);
		
		piece = 'O';
		board[2][0] = piece;
		boardObj.addPieces(3, piece);

		assertNotEquals(board, boardObj.board);
	}

	@Test
	public void testVerticalWin() {
		char piece = 'O';
		int col = 1;
		
		for(int row=4; row<8; row++) {
			boardObj.board[col][row] = piece;
		}
		
		assertTrue(boardObj.isVerticalWin());
	}
	
	@Test
	public void testVerticalWin2() {
		char piece = 'X';
		int col = 7;
		
		for(int row=4; row<8; row++) {
			boardObj.board[col][row] = piece;
		}
		
		assertTrue(boardObj.isVerticalWin());
	}
	
	@Test
	public void testVerticalWin3() {
		char piece = 'X';
		int col = 0;
		
		for(int row=0; row<4; row++) {
			boardObj.board[col][row] = piece;
		}
		
		assertTrue(boardObj.isVerticalWin());
	}
	
	@Test
	public void testVerticalWin4() {
		char piece = 'X';
		int col = 7;
		
		for(int row=0; row<4; row++) {
			boardObj.board[col][row] = piece;
		}
		
		assertTrue(boardObj.isVerticalWin());
	}

	@Test
	public void testIsHorizonalWin() {
		char piece = 'X';
		int row = 7;
		
		for(int col=4; col<8; col++) {
			boardObj.board[col][row] = piece;
		}
		
		assertTrue(boardObj.isHorizontalWin());
	}
	
	@Test
	public void testIsHorizonalWin2() {
		char piece = 'O';
		int row = 0;
		
		for(int col=4; col<8; col++) {
			boardObj.board[col][row] = piece;
		}
		
		assertTrue(boardObj.isHorizontalWin());
	}
	
	@Test
	public void testIsHorizonalWin3() {
		char piece = 'O';
		int row = 0;
		
		for(int col=0; col<4; col++) {
			boardObj.board[col][row] = piece;
		}
		
		assertTrue(boardObj.isHorizontalWin());
	}
	
	@Test
	public void testIsHorizonalWin4() {
		char piece = 'O';
		int row = 7;
		
		for(int col=0; col<4; col++) {
			boardObj.board[col][row] = piece;
		}
		
		assertTrue(boardObj.isHorizontalWin());
	}

	@Test
	public void testCheckBottomLeftTopRightDiagonal() {
		int row = 0;
		int col = 0;
		char piece = 'X';
		
		for(int step=0; step<4; step++) {
			boardObj.board[row + step][col + step] = piece;
		}
		
		assertTrue(boardObj.checkBottomLeftTopRightDiagonal());
	}
	
	@Test
	public void testCheckBottomLeftTopRightDiagonal2() {
		int row = 4;
		int col = 4;
		char piece = 'X';
		
		for(int step=0; step<4; step++) {
			boardObj.board[row + step][col + step] = piece;
		}
		
		assertTrue(boardObj.checkBottomLeftTopRightDiagonal());
	}
	
	@Test
	public void testCheckBottomLeftTopRightDiagonal3() {
		int row = 4;
		int col = 0;
		char piece = 'O';
		
		for(int step=0; step<4; step++) {
			boardObj.board[row + step][col + step] = piece;
		}
		
		assertTrue(boardObj.checkBottomLeftTopRightDiagonal());
	}
	
	@Test
	public void testCheckBottomLeftTopRightDiagonal4() {
		int row = 0;
		int col = 4;
		char piece = 'O';
		
		for(int step=0; step<4; step++) {
			boardObj.board[row + step][col + step] = piece;
		}
		
		assertTrue(boardObj.checkBottomLeftTopRightDiagonal());
	}
	
	@Test
	public void testCheckTopLeftBottomRightDiagonal() {
		int row = 7;
		int col = 0;
		char piece = 'O';
		
		for(int step=0; step<4; step++) {
			boardObj.board[row - step][col + step] = piece;
		}
		
		assertTrue(boardObj.checkTopLeftBottomRightDiagonal());
	}
	
	@Test
	public void testCheckTopLeftBottomRightDiagonal2() {
		int row = 3;
		int col = 3;
		char piece = 'O';
		
		for(int step=0; step<4; step++) {
			boardObj.board[row - step][col + step] = piece;
		}
		
		assertTrue(boardObj.checkTopLeftBottomRightDiagonal());
	}
	
	@Test
	public void testCheckTopLeftBottomRightDiagonal3() {
		int row = 3;
		int col = 0;
		char piece = 'O';
		
		for(int step=0; step<4; step++) {
			boardObj.board[row - step][col + step] = piece;
		}
		
		assertTrue(boardObj.checkTopLeftBottomRightDiagonal());
	}
	
	@Test
	public void testCheckTopLeftBottomRightDiagonal4() {
		int row = 7;
		int col = 4;
		char piece = 'O';
		
		for(int step=0; step<4; step++) {
			boardObj.board[row - step][col + step] = piece;
		}
		
		assertTrue(boardObj.checkTopLeftBottomRightDiagonal());
	}
	
	@Test
	public void testGameTie() {
        for(int col = 0; col < 8; col++) {
            for(int row = 0; row < 8; row++) {
            	boardObj.board[col][row] = 'X';
            }
        }
		assertTrue(boardObj.isTie());
	}
	
	@Test
	public void testGameTieShouldFail() {
		assertFalse(boardObj.isTie());
	}
}
