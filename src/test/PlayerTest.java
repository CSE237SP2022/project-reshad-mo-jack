package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Player;

class PlayerTest {
	private Player player1;
	private Player player2;

	@BeforeEach
	public void setup() {
		player1 = new Player("Player1", 'X');
		player2 = new Player("Player2", 'O');
	}
	
	@Test
	public void testPlayerConstructorName() {
		String name = "Player1";
		assertTrue(name.equals(player1.name));
	}
	
	@Test
	public void testPlayerConstructorPiece() {
		char piece = 'X';
		assertEquals(piece, player1.piece);
	}
	
	@Test
	public void testPlayerConstructorShouldFailName() {
		String name = "Player1";
		assertNotEquals(name, player2.piece);
	}
	
	@Test
	public void testPlayerConstructorShouldFailPiece() {
		char piece = 'O';
		assertNotEquals(piece, player1.piece);
	}
	
}
