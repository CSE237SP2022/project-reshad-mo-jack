package main;

public class ConnectFour {
	public Board boardObj;
	public int currentTurnPlayer;
	public Player[] players;
	public Input inputObj;
	public Display displayObj;

	public static void main(String[] args) {
		ConnectFour game = new ConnectFour();
		game.play();
	}

	public ConnectFour() {
		this.currentTurnPlayer = 0;
		this.players = new Player[2];
		this.inputObj = new Input();
	}

	public void play() {
		setPlayerInformation();
		int dimension = inputObj.getInputBoardDimension();
		boardObj = new Board(dimension);
		char[][] board = boardObj.getBoard();
		displayObj = new Display();
		displayObj.printGame(getCurrentPlayerName(), board);

		while (!isGameEnd()) {
			int col = inputObj.getInputValidColumn(dimension, board);
			boardObj.addPieces(col, getCurrentPlayerPiece());
			changeTurns();
			displayObj.printGame(getCurrentPlayerName(), board);
		}

		displayGameEndStatus();
	}

	public void displayGameEndStatus() {
		String winningPlayerName = players[1 - currentTurnPlayer].name;
		displayObj.printGameEndStatus(boardObj.isTie(), winningPlayerName);
	}

	public void setPlayerInformation() {
		char[] pieces = new char[] { 'X', 'O' };

		for (int playerNumber = 0; playerNumber < players.length; playerNumber++) {
			String name = inputObj.getInputValidPlayerName(playerNumber);
			char piece = pieces[playerNumber];
			players[playerNumber] = new Player(name, piece);
		}
	}

	public String getCurrentPlayerName() {
		return players[currentTurnPlayer].name;
	}

	public char getCurrentPlayerPiece() {
		return players[currentTurnPlayer].piece;
	}

	public void changeTurns() {
		if (currentTurnPlayer == 0) {
			currentTurnPlayer = 1;
		} else {
			currentTurnPlayer = 0;
		}
	}

	public boolean isGameEnd() {
		return boardObj.isVerticalWin() || boardObj.isHorizontalWin() || boardObj.isDiagonalWin() || boardObj.isTie();
	}
}