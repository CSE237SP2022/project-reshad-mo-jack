package test;

public class ConnectFourTest {

	@Test
	void addNames() {
		ConnectFour game = new ConnectFour();
		String input = "name1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		game.playerNames("1")
		assertEquals("name1", game.getPlayerNames[0]);
	}

	@Test
	void wrongNames() {
		ConnectFour game = new ConnectFour();
		String input = "name2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		game.playerNames("2")
		assertFalse("name2".equals(game.getPlayerNames[1]));
	}

}