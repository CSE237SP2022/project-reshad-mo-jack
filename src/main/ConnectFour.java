package main;

import java.util.Scanner;

public class ConnectFour {
    //0 no piece, player 1 is 1, player 2 is 2
    private static int [][] board; 
    private static String player1;
    private static String player2;

    public static void main(String[] args) {
        board = new int [8][8];

        ConnectFour game = new ConnectFour();
        //input player names
        //enter player1 name
        game.playerNames("1");
        //enter player2 name
        game.playerNames("2");
        //no grid size yet, start with 8 cols, 8 rows
        //later on, give options

        //we give player option of cols
        //each column is an array within our 2d array(maybe in future iteration, make new structures)
        

        //when a player makes a move, we determine if move is valid, we check size of that column<8
        
        //after the move we check if the game has been won
        System.out.println("Game end");
    }

    //playerID is a string, either '1' or '2'
    public void playerNames(String playerID) { 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username for player " + playerID);
        if (scanner.hasNextLine()) {
        	 String name = scanner.nextLine();
        	 if (playerID.equals("1")) {
                 player1 = name;
             } else {
                 player2 = name;
             }
             System.out.println("Player " + playerID + ": " + name);   
        } 
    }

    public String[] getPlayerNames() {
        return new String [] {player1, player2};
    }

    public boolean validMove(int col) {
        if (col<=0 || col>8) return false;
        if (board[col+1][7]!=0) return false;
        return true;
    }

    public int gameWon() {
        //do this after a player does a move
        //only check if that last move is a winning move
    	return 0;
    }

    public void printBoard() {
    	String frontSpacing = "   ";

    	System.out.println();
    	printHorizontalLine(frontSpacing);
    	printRow(frontSpacing);
    	printColumnLabel();
    }
    
    public void printHorizontalLine(String frontSpacing) {
    	int rows = board.length;
    	String cellBorderTopOrBottom = "--";
    	String cellBorderTopOrBottomEdge = "-";
    	
    	System.out.print(frontSpacing);
    	System.out.print(cellBorderTopOrBottomEdge);
    	for(int r=rows-1; r>=0; r--) {
        	System.out.print(cellBorderTopOrBottom);
    	}
    	System.out.println();
    }
    
    public void printRow(String frontSpacing) {
    	int rows = board.length;
    	int cols = board[0].length;
    	String spacingAfterLabel = "  "; 
    	String cellBorderSide = "|";
    	
    	for(int r=rows-1; r>=0; r--) {  
    		System.out.print((r+1) + spacingAfterLabel + cellBorderSide);
    		for(int c=cols-1; c>=0; c--) {
    			System.out.print(board[r][c] + cellBorderSide);
    		}
    		System.out.println();
    		printHorizontalLine(frontSpacing);
    	}
    }
    
    public void printColumnLabel() {
    	int cols = board[0].length;
    	String frontSpacing = "    ";
    	String spacingBetweenColumnLabels = " ";

    	System.out.print(frontSpacing);
    	for(int c=1; c<=cols; c++) {
    		System.out.print(c + spacingBetweenColumnLabels);
    	}
    	
    	System.out.println();
    }


}