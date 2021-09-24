import java.io.IOException;

/**
 * Class Name: Referee
 * 
 * This class is used to set up the board and players for a game of tic-tac-toe and then run the game.
 * 
 * 
 * @author Calvin Giese (Copied from d2l) 
 * @version version 1.0
 * @since September 23, 2021
 *
 */

public class Referee {
	
	/**
	 * The player who will use X's
	 */
	private Player xPlayer;
	
	/**
	 * The player who will use O's
	 */
	private Player oPlayer;
	
	/**
	 * The board to play the game on
	 */
	private Board board;
	
	/**
	 * Constructs the players and board, initially set to a null
	 */
	public Referee() {
		this.board = null;;
		this.xPlayer = null;
		this.oPlayer = null;
	}
	
	/**
	 * 
	 * This method sets the players as opponents and runs the game until it is done
	 * 
	 * @throws IOException
	 */
	public void runTheGame() throws IOException {
		this.xPlayer.setOpponent(oPlayer);
		this.oPlayer.setOpponent(xPlayer);
		
		if(this.xPlayer.isDone() == false) {
			System.out.println("Referee has started the game...\n");
			this.board.display();
			this.xPlayer.play();
		}
	}
	
	/**
	 * 
	 * Sets the board for the game to be played on
	 * 
	 * @param board is the game board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * 
	 * Sets the player who will use O's for the game
	 * 
	 * @param oPlayer is the player who will play O's
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}
	
	/**
	 * 
	 * Sets the player who will use X's for the game
	 * 
	 * @param oPlayer is the player who will play X's
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}

}
