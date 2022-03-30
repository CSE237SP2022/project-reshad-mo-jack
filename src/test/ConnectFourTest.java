package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import main.ConnectFour;

public class ConnectFourTest {
  @Test
  void addPieceBelowBoard() {
      ConnectFour game = new ConnectFour();
      boolean wasValid = game.validMove(0);
      assertEquals(wasValid, false);
  }

  @Test
  void addPiecePastBoard() {
      ConnectFour game = new ConnectFour();
      boolean wasValid = game.validMove(9);
      assertEquals(wasValid, false);
  }

  @Test
	void addNames() {
		ConnectFour game = new ConnectFour();
		String input = "name1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		game.playerNames("1");
		assertTrue("name1".equals(game.getPlayerNames()[0]));
	}

	@Test
	void wrongNames() {
		ConnectFour game = new ConnectFour();
		String input = "name2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		game.playerNames("2");
		assertFalse("name2".equals(game.getPlayerNames()[1]));
	}
}
