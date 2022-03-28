package test;

public class ConnectFourTest {

    /*@Test
	void addPieceToFullColumn() {
        
        
    }*/

    @Test
    void addPieceBelowBoard() {
        ConnectFour board = new Board();
        boolean wasValid = Board.validMove(0);
        assertEquals(wasValid,False);
    }

    @Test
    void addPiecePastBoard() {
        ConnectFour board = new Board();
        boolean wasValid = Board.validMove(9);
        assertEquals(wasValid,False);
    }
}
