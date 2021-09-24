import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Name: Player
 * 
 * This class is used to identify a player by their name and marker as well as knowledge of the board condition and who their opponent is.
 * 
 * 
 * @author Calvin Giese (Copied from d2l) 
 * @version version 1.0
 * @since September 23, 2021
 *
 */

public class Player {
	
	/**
	 * The name of the player
	 */
	private String name;
	
	/**
	 * The board to play the game on
	 */
	private Board board;
	
	/**
	 * The opponent of this player
	 */
	private Player opponent;
	
	/**
	 * Either X or O, whichever marker the player is using
	 */
	private char mark;
	
	/**
	 * Indicator of the game being complete
	 */
	private boolean done;

	/**
	 * Constructs a new player from the variables passed, setting their name, marker and the game as incomplete
	 * 
	 * @param name is the name of the player
	 * @param mark is the character to play with (X or O)
	 */
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
		this.done = false;
	}
	
	/**
	 * 
	 * Allows the two players take turns back and forth until one of them is the winner or the board is full, which results in a draw.
	 * X will always go first in this game so it is built to produce results as such.
	 * 
	 * @throws IOException
	 */
	public void play() throws IOException {
		
		while(this.board.isFull() == false && this.board.xWins() == false && this.board.oWins() == false) {			
			makeMove();
			
			if(this.board.isFull() == false && this.board.xWins() == false && this.board.oWins() == false) {
				opponent.makeMove();
				if(this.board.oWins() == true) {
					System.out.println('\n' + "THE GAME IS OVER: The winner is " + opponent.name + '!' + '\n');
				}
			}
			else {
				if(this.board.oWins() == true) {
					System.out.println('\n' + "THE GAME IS OVER: The winner is " + opponent.name + '!' + '\n');
				}
				else if(this.board.xWins() == true) {
					System.out.println('\n' + "THE GAME IS OVER: The winner is " + this.name + '!' + '\n');
				}
				else {
					System.out.println('\n' + "The game resulted in a tie" + '\n');
				}
			}
		}
		System.out.println("\nGame Ended...");
		this.done = true;
	}
	
	/**
	 * 
	 * Getter to determine whether the game is over or not
	 * 
	 * @return true if the game is done
	 */
	public boolean isDone() {
		return done;
	}
	
	/**
	 * 
	 * This method is used to identify the place that the player would like to take on the board, place their marker and display
	 * the updated board.
	 * 
	 * @throws IOException
	 */
	public void makeMove() throws IOException {
		BufferedReader b1 = new BufferedReader(new InputStreamReader(System.in));
		String strRow;
		String strCol;
		boolean rowColError = true;
		boolean validEntry = false;
		int row = -1, column = -1;
		
		while(validEntry == false) {
		
			while(rowColError == true){
				System.out.print("\nPlease enter the row that your marker should be placed in:");
				strRow = b1.readLine();
				while (strRow == null) {
					System.out.print("Please try again: ");
					strRow = b1.readLine();
				}
				
				System.out.print("\nPlease enter the column that your marker should be placed in:");
				strCol = b1.readLine();
				while (strCol == null) {
					System.out.print("Please try again: ");
					strCol = b1.readLine();
				}

				try {
					column = Integer.parseInt(strCol);
					row = Integer.parseInt(strRow);
					if((row + column) % 1 == 0) {
						rowColError = false;
					}
				} catch(NumberFormatException e){
					System.out.println("That was an invalid entry, please try again" + '\n');
				}
			}
			
			if(row >= 0 && column >= 0 && row <= 2 && column <= 2) {
				if(this.board.getMark(row, column) == ' ') {
					this.board.addMark(row, column, this.mark);
					this.board.display();
					validEntry = true;
				}
				else {
					rowColError = true;
					System.out.println("\nThat was an invalid entry, please try again.");
				}
			}
			else {
				rowColError = true;
				System.out.println("\nThat was an invalid entry, please try again.");
			}
		}
		
	}
	
	/**
	 * 
	 * Sets the opponent of the current player
	 * 
	 * @param opponent is the player who will be competed against
	 */
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	/**
	 * 
	 * Sets the board to the condition of the board in the passed argument
	 * 
	 * @param board is the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * 
	 * Getter used to retrieve the player's name
	 * 
	 * @return the name of the player
	 */
	public String getName() {
		return this.name;
	}
}
