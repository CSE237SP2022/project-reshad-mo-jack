package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

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
//		System.setIn(in);
		game.playerNames(game.scanner, "1");
		assertTrue("name1".equals(game.getPlayerNames()[0]));
	}

	@Test
	void wrongNames() {
		String input = "name2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
//		System.setIn(in);
		game.playerNames(game.scanner, "2");
		assertFalse("name2".equals(game.getPlayerNames()[1]));
	}
}
