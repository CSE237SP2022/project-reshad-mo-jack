package main;
public class ConnectFour {
    //0 no piece, player 1 is 1, player 2 is 2
    private static int [][] board; 
    private static String player1;
    private static String player2;

    public static void main(String[] args) {
        board = new int [8][8];


        //input player names
        //enter player1 name
        //enter player2 name

        //no grid size yet, start with 8 cols, 8 rows
        //later on, give options

        //we give player option of cols
        //each column is an array within our 2d array(maybe in future iteration, make new structures)
        

        //when a player makes a move, we determine if move is valid, we check size of that column<8
        
        //after the move we check if the game has been won
    }

    public void playerNames() {

    }

    public boolean validMove(int col) {
        if (col<=0 || col>8) return false
        if (this.board[col+1][7]!=0) return false;
        return true;
    }

    public int gameWon() {
        //do this after a player does a move
        //only check if that last move is a winning move
    	return 0;
    }


    public void printBoard() {

    }


}