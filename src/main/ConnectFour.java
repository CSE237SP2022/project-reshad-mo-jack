package main;

import java.util.Scanner;

public class ConnectFour {
    //0 no piece, player 1 is 1, player 2 is 2
    public int [][] board; 
    private String player1;
    private String player2;
    public Scanner scanner;

    public static void main(String[] args) {
    	int[][] board = new int[8][8];
    	Scanner scanner = new Scanner(System.in);
        ConnectFour game = new ConnectFour(board, scanner);
        game.playerNames(scanner, "1");
        game.playerNames(scanner, "2");
        game.printBoard();
    }
    
    public ConnectFour(int[][] board, Scanner scanner) {
    	this.board = board;
    	this.scanner = scanner;
    }

    //playerID is a string, either '1' or '2'
    public void playerNames(Scanner scanner, String playerID) { 
        System.out.println("Enter username for player " + playerID);
        if (this.scanner.hasNextLine()) {
        	 String name = this.scanner.nextLine();
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
        // col must be between 0 and 7 inclusive, for a 8x8 board
        if (col<0 || col>8) return false;
        if (board[col][7]!=0) return false;
        return true;
    }

    public boolean gameWon() { //do this after a player does a move
        //loop through all unit on board
        int rowSize = board.length;
    	int colSize = board[0].length;
        for(int row = 0; row < rowSize; row ++) {
            for(int col = 0; col < colSize; col ++) {
                //detect if horizontal 4
                if (board[row][col] != 0 && col + 1 < colSize && col + 2 < colSize && col + 3 < colSize) {
                    if (board[row][col] == board[row][col + 1] && board[row][col] == board[row][col + 2] && board[row][col] == board[row][col + 3]) {
                        return true;
                    } 
                }
                //detect if vertical 4
                if (board[row][col] != 0 && row + 1 < rowSize && row + 2 < rowSize && row + 3 < rowSize) {
                    if (board[row][col] == board[row + 1][col] && board[row][col] == board[row + 2][col] && board[row][col] == board[row + 3][col]) {
                        return true;
                    } 
                }
                //detect if diagnol 4
                if (board[row][col] != 0 && row + 1 < rowSize && row + 2 < rowSize && row + 3 < rowSize && col + 1 < colSize && col + 2 < colSize && col + 3 < colSize) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row][col] == board[row + 2][col + 2] && board[row][col] == board[row + 3][col + 3]) {
                        return true;
                    } 
                }
                if (board[row][col] != 0 && row + 1 < rowSize && row + 2 < rowSize && row + 3 < rowSize && col - 1 >= 0 && col - 2 >= 0 && col - 3 >= 0) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row][col] == board[row + 2][col - 2] && board[row][col] == board[row + 3][col - 3]) {
                        return true;
                    } 
                }
            }
        }
    	return false;
    }

    public boolean gameTie() {
        int rowSize = board.length;
        for(int row = 0; row < rowSize; row ++) {
            if (board[row][7] != 0) {
                return true;
            }
        }
        return false;
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